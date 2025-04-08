package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.UsersEntity;
import java.util.Map;

/**
 * 管理员表 服务类
 */
public interface UsersService extends IService<UsersEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}