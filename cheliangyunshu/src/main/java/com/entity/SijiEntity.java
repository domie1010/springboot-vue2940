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
 * 司机
 *
 * @author 
 * @email
 */
@TableName("siji")
public class SijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SijiEntity() {

	}

	public SijiEntity(T t) {
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

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 司机姓名
     */
    @TableField(value = "siji_name")

    private String sijiName;


    /**
     * 司机手机号
     */
    @TableField(value = "siji_phone")

    private String sijiPhone;


    /**
     * 司机身份证号
     */
    @TableField(value = "siji_id_number")

    private String sijiIdNumber;


    /**
     * 司机照片
     */
    @TableField(value = "siji_photo")

    private String sijiPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 司机状态
     */
    @TableField(value = "siji_yesno_types")

    private Integer sijiYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
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
	 * 设置：司机姓名
	 */
    public String getSijiName() {
        return sijiName;
    }


    /**
	 * 获取：司机姓名
	 */

    public void setSijiName(String sijiName) {
        this.sijiName = sijiName;
    }
    /**
	 * 设置：司机手机号
	 */
    public String getSijiPhone() {
        return sijiPhone;
    }


    /**
	 * 获取：司机手机号
	 */

    public void setSijiPhone(String sijiPhone) {
        this.sijiPhone = sijiPhone;
    }
    /**
	 * 设置：司机身份证号
	 */
    public String getSijiIdNumber() {
        return sijiIdNumber;
    }


    /**
	 * 获取：司机身份证号
	 */

    public void setSijiIdNumber(String sijiIdNumber) {
        this.sijiIdNumber = sijiIdNumber;
    }
    /**
	 * 设置：司机照片
	 */
    public String getSijiPhoto() {
        return sijiPhoto;
    }


    /**
	 * 获取：司机照片
	 */

    public void setSijiPhoto(String sijiPhoto) {
        this.sijiPhoto = sijiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：司机状态
	 */
    public Integer getSijiYesnoTypes() {
        return sijiYesnoTypes;
    }


    /**
	 * 获取：司机状态
	 */

    public void setSijiYesnoTypes(Integer sijiYesnoTypes) {
        this.sijiYesnoTypes = sijiYesnoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Siji{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", sijiName=" + sijiName +
            ", sijiPhone=" + sijiPhone +
            ", sijiIdNumber=" + sijiIdNumber +
            ", sijiPhoto=" + sijiPhoto +
            ", sexTypes=" + sexTypes +
            ", sijiYesnoTypes=" + sijiYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
