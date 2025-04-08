package com.dao;

import com.entity.CarEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CarView;

/**
 * 车辆 Dao 接口
 *
 * @author 
 */
public interface CarDao extends BaseMapper<CarEntity> {

   List<CarView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
