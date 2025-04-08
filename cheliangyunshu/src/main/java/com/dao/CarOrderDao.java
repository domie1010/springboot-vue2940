package com.dao;

import com.entity.CarOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CarOrderView;

/**
 * 订单 Dao 接口
 *
 * @author 
 */
public interface CarOrderDao extends BaseMapper<CarOrderEntity> {

   List<CarOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
