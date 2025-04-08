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
 * 车辆
 *
 * @author 
 * @email
 */
@TableName("car")
public class CarEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CarEntity() {

	}

	public CarEntity(T t) {
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
     * 车辆名字
     */
    @TableField(value = "car_name")

    private String carName;


    /**
     * 车辆类型
     */
    @TableField(value = "car_types")

    private Integer carTypes;


    /**
     * 车辆品牌类型
     */
    @TableField(value = "car_pinpai_types")

    private Integer carPinpaiTypes;


    /**
     * 车牌号
     */
    @TableField(value = "car_pai_number")

    private String carPaiNumber;


    /**
     * 车辆照片
     */
    @TableField(value = "car_photo")

    private String carPhoto;


    /**
     * 是否在使用
     */
    @TableField(value = "car_yesno_types")

    private Integer carYesnoTypes;


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
	 * 设置：车辆名字
	 */
    public String getCarName() {
        return carName;
    }


    /**
	 * 获取：车辆名字
	 */

    public void setCarName(String carName) {
        this.carName = carName;
    }
    /**
	 * 设置：车辆类型
	 */
    public Integer getCarTypes() {
        return carTypes;
    }


    /**
	 * 获取：车辆类型
	 */

    public void setCarTypes(Integer carTypes) {
        this.carTypes = carTypes;
    }
    /**
	 * 设置：车辆品牌类型
	 */
    public Integer getCarPinpaiTypes() {
        return carPinpaiTypes;
    }


    /**
	 * 获取：车辆品牌类型
	 */

    public void setCarPinpaiTypes(Integer carPinpaiTypes) {
        this.carPinpaiTypes = carPinpaiTypes;
    }
    /**
	 * 设置：车牌号
	 */
    public String getCarPaiNumber() {
        return carPaiNumber;
    }


    /**
	 * 获取：车牌号
	 */

    public void setCarPaiNumber(String carPaiNumber) {
        this.carPaiNumber = carPaiNumber;
    }
    /**
	 * 设置：车辆照片
	 */
    public String getCarPhoto() {
        return carPhoto;
    }


    /**
	 * 获取：车辆照片
	 */

    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }
    /**
	 * 设置：是否在使用
	 */
    public Integer getCarYesnoTypes() {
        return carYesnoTypes;
    }


    /**
	 * 获取：是否在使用
	 */

    public void setCarYesnoTypes(Integer carYesnoTypes) {
        this.carYesnoTypes = carYesnoTypes;
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
        return "Car{" +
            "id=" + id +
            ", carName=" + carName +
            ", carTypes=" + carTypes +
            ", carPinpaiTypes=" + carPinpaiTypes +
            ", carPaiNumber=" + carPaiNumber +
            ", carPhoto=" + carPhoto +
            ", carYesnoTypes=" + carYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
