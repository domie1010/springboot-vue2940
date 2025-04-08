package com.entity.model;

import com.entity.UsersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 管理员表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class UsersModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Long id;


    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 角色
     */
    private String role;


    /**
     * 新增时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date addtime;


    /**
	 * 获取：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 获取：用户名
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：用户名
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：角色
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 设置：角色
	 */
    public void setRole(String role) {
        this.role = role;
    }
    /**
	 * 获取：新增时间
	 */
    public Date getAddtime() {
        return addtime;
    }


    /**
	 * 设置：新增时间
	 */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    }
