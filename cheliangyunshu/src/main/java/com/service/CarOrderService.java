package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CarOrderEntity;
import java.util.Map;

/**
 * 订单 服务类
 */
public interface CarOrderService extends IService<CarOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}