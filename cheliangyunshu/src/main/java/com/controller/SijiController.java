package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.SijiEntity;

import com.service.SijiService;
import com.entity.view.SijiView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 司机
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/siji")
public class SijiController {
    private static final Logger logger = LoggerFactory.getLogger(SijiController.class);

    @Autowired
    private SijiService sijiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("司机".equals(role))
            params.put("sijiId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = sijiService.queryPage(params);

        //字典表数据转换
        List<SijiView> list =(List<SijiView>)page.getList();
        for(SijiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SijiEntity siji = sijiService.selectById(id);
        if(siji !=null){
            //entity转view
            SijiView view = new SijiView();
            BeanUtils.copyProperties( siji , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,siji:{}",this.getClass().getName(),siji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<SijiEntity> queryWrapper = new EntityWrapper<SijiEntity>()
            .eq("username", siji.getUsername())
            .or()
            .eq("siji_phone", siji.getSijiPhone())
            .or()
            .eq("siji_id_number", siji.getSijiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiEntity sijiEntity = sijiService.selectOne(queryWrapper);
        if(sijiEntity==null){
            siji.setCreateTime(new Date());
            siji.setPassword("123456");
            sijiService.insert(siji);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,siji:{}",this.getClass().getName(),siji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<SijiEntity> queryWrapper = new EntityWrapper<SijiEntity>()
            .notIn("id",siji.getId())
            .andNew()
            .eq("username", siji.getUsername())
            .or()
            .eq("siji_phone", siji.getSijiPhone())
            .or()
            .eq("siji_id_number", siji.getSijiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SijiEntity sijiEntity = sijiService.selectOne(queryWrapper);
        if("".equals(siji.getSijiPhoto()) || "null".equals(siji.getSijiPhoto())){
                siji.setSijiPhoto(null);
        }
        if(sijiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      siji.set
            //  }
            sijiService.updateById(siji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        sijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SijiEntity siji = sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("username", username));
        if(siji==null || !siji.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(siji.getId(),username, "siji", "司机");
        R r = R.ok();
        r.put("token", token);
        r.put("role","司机");
        r.put("username",siji.getSijiName());
        r.put("tableName","siji");
        r.put("userId",siji.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SijiEntity siji){
    //    	ValidatorUtils.validateEntity(user);
        if(sijiService.selectOne(new EntityWrapper<SijiEntity>().eq("username", siji.getUsername()).orNew().eq("siji_phone",siji.getSijiPhone()).orNew().eq("siji_id_number",siji.getSijiIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        siji.setCreateTime(new Date());
        siji.setSijiYesnoTypes(1);
        sijiService.insert(siji);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        SijiEntity siji = new SijiEntity();
        siji.setPassword("123456");
        siji.setId(id);
        sijiService.updateById(siji);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSiji(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SijiEntity siji = sijiService.selectById(id);
        if(siji !=null){
            //entity转view
            SijiView view = new SijiView();
            BeanUtils.copyProperties( siji , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

