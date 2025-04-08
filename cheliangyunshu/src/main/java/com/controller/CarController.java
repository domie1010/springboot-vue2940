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

import com.entity.CarEntity;

import com.service.CarService;
import com.entity.view.CarView;
import com.service.SijiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/car")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = carService.queryPage(params);

        //字典表数据转换
        List<CarView> list =(List<CarView>)page.getList();
        for(CarView c:list){
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
        CarEntity car = carService.selectById(id);
        if(car !=null){
            //entity转view
            CarView view = new CarView();
            BeanUtils.copyProperties( car , view );//把实体数据重构到view中

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
    public R save(@RequestBody CarEntity car, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,car:{}",this.getClass().getName(),car.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<CarEntity> queryWrapper = new EntityWrapper<CarEntity>()
            .eq("car_name", car.getCarName())
            .eq("car_types", car.getCarTypes())
            .eq("car_pinpai_types", car.getCarPinpaiTypes())
            .eq("car_pai_number", car.getCarPaiNumber())
            .eq("car_yesno_types", car.getCarYesnoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CarEntity carEntity = carService.selectOne(queryWrapper);
        if(carEntity==null){
            car.setCreateTime(new Date());
            carService.insert(car);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CarEntity car, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,car:{}",this.getClass().getName(),car.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<CarEntity> queryWrapper = new EntityWrapper<CarEntity>()
            .notIn("id",car.getId())
            .andNew()
            .eq("car_name", car.getCarName())
            .eq("car_types", car.getCarTypes())
            .eq("car_pinpai_types", car.getCarPinpaiTypes())
            .eq("car_pai_number", car.getCarPaiNumber())
            .eq("car_yesno_types", car.getCarYesnoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CarEntity carEntity = carService.selectOne(queryWrapper);
        if("".equals(car.getCarPhoto()) || "null".equals(car.getCarPhoto())){
                car.setCarPhoto(null);
        }
        if(carEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      car.set
            //  }
            carService.updateById(car);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        carService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

