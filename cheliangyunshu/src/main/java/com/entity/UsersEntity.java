package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 管理员表
 *
 * @author 
 * @email
 */
@TableName("users")
public class UsersEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public UsersEntity() {

	}

	public UsersEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Long id;


    /**
     * 用户名
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 角色
     */
    @TableField(value = "role")

    private String role;


    /**
     * 新增时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "addtime")

    private Date addtime;


    /**
	 * 设置：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 设置：用户名
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：用户名
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：角色
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：角色
	 */

    public void setRole(String role) {
        this.role = role;
    }
    /**
	 * 设置：新增时间
	 */
    public Date getAddtime() {
        return addtime;
    }


    /**
	 * 获取：新增时间
	 */

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Users{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", role=" + role +
            ", addtime=" + addtime +
        "}";
    }
}
