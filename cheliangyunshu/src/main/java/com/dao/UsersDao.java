package com.dao;

import com.entity.UsersEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.UsersView;

/**
 * 管理员表 Dao 接口
 *
 * @author 
 */
public interface UsersDao extends BaseMapper<UsersEntity> {

   List<UsersView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
