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

import com.entity.CarOrderEntity;

import com.service.CarOrderService;
import com.entity.view.CarOrderView;
import com.service.CarService;
import com.entity.CarEntity;
import com.service.SijiService;
import com.entity.SijiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/carOrder")
public class CarOrderController {
    private static final Logger logger = LoggerFactory.getLogger(CarOrderController.class);

    @Autowired
    private CarOrderService carOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private CarService carService;
    @Autowired
    private SijiService sijiService;


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
        PageUtils page = carOrderService.queryPage(params);

        //字典表数据转换
        List<CarOrderView> list =(List<CarOrderView>)page.getList();
        for(CarOrderView c:list){
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
        CarOrderEntity carOrder = carOrderService.selectById(id);
        if(carOrder !=null){
            //entity转view
            CarOrderView view = new CarOrderView();
            BeanUtils.copyProperties( carOrder , view );//把实体数据重构到view中

            //级联表
            CarEntity car = carService.selectById(carOrder.getCarId());
            if(car != null){
                BeanUtils.copyProperties( car , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setCarId(car.getId());
            }
            //级联表
            SijiEntity siji = sijiService.selectById(carOrder.getSijiId());
            if(siji != null){
                BeanUtils.copyProperties( siji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setSijiId(siji.getId());
            }
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
    public R save(@RequestBody CarOrderEntity carOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,carOrder:{}",this.getClass().getName(),carOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("司机".equals(role))
            carOrder.setSijiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        CarEntity carEntity = carService.selectById(carOrder.getCarId());
        if(carEntity == null || carEntity.getCarYesnoTypes() == 2)
            return R.error(511,"查不到车辆或者车辆正在被使用");
        SijiEntity sijiEntity = sijiService.selectById(carOrder.getSijiId());
        if(sijiEntity == null || sijiEntity.getSijiYesnoTypes() == 2)
            return R.error(511,"查不到司机或者司机正在工作中");


        carEntity.setCarYesnoTypes(2);
        carService.updateById(carEntity);//把车辆状态设置为使用中

        sijiEntity.setSijiYesnoTypes(2);
        sijiService.updateById(sijiEntity);//把司机状态设置为工作中


        carOrder.setInsertTime(new Date());
        carOrder.setCreateTime(new Date());
        carOrderService.insert(carOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CarOrderEntity carOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,carOrder:{}",this.getClass().getName(),carOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("司机".equals(role))
            carOrder.setSijiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        CarOrderEntity oldCarOrderEntity = carOrderService.selectById(carOrder.getId());
        if(carOrder.getCarOrderYesnoTypes() == 2 && oldCarOrderEntity.getCarOrderYesnoTypes() == 1){
            //之前订单状态是运输中,改为完成, 更新司机状态和车辆状态
            CarEntity carEntity = carService.selectById(carOrder.getCarId());
            if(carEntity != null){
                carEntity.setCarYesnoTypes(1);
                carService.updateById(carEntity);
            }
            SijiEntity sijiEntity = sijiService.selectById(carOrder.getSijiId());
            if(sijiEntity != null ){
                sijiEntity.setSijiYesnoTypes(1);
                sijiService.updateById(sijiEntity);
            }
        }else if(carOrder.getCarOrderYesnoTypes() == 1){
            // 老的全部设置为空闲
            CarEntity oldCarEntity = carService.selectById(oldCarOrderEntity.getCarId());
            if(oldCarEntity != null){
                oldCarEntity.setCarYesnoTypes(1);
                carService.updateById(oldCarEntity);
            }
            SijiEntity oldSijiEntity = sijiService.selectById(oldCarOrderEntity.getSijiId());
            if(oldSijiEntity != null ){
                oldSijiEntity.setSijiYesnoTypes(1);
                sijiService.updateById(oldSijiEntity);
            }

            // 新的全部设置为使用中
            CarEntity carEntity = carService.selectById(carOrder.getCarId());
            if(carEntity != null){
                carEntity.setCarYesnoTypes(2);
                carService.updateById(carEntity);
            }
            SijiEntity sijiEntity = sijiService.selectById(carOrder.getSijiId());
            if(sijiEntity != null ){
                sijiEntity.setSijiYesnoTypes(2);
                sijiService.updateById(sijiEntity);
            }


        }

        carOrderService.updateById(carOrder);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        carOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

