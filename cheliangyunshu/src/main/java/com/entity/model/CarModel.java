package com.entity.model;

import com.entity.CarEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆名字
     */
    private String carName;


    /**
     * 车辆类型
     */
    private Integer carTypes;


    /**
     * 车辆品牌类型
     */
    private Integer carPinpaiTypes;


    /**
     * 车牌号
     */
    private String carPaiNumber;


    /**
     * 车辆照片
     */
    private String carPhoto;


    /**
     * 是否在使用
     */
    private Integer carYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：车辆名字
	 */
    public String getCarName() {
        return carName;
    }


    /**
	 * 设置：车辆名字
	 */
    public void setCarName(String carName) {
        this.carName = carName;
    }
    /**
	 * 获取：车辆类型
	 */
    public Integer getCarTypes() {
        return carTypes;
    }


    /**
	 * 设置：车辆类型
	 */
    public void setCarTypes(Integer carTypes) {
        this.carTypes = carTypes;
    }
    /**
	 * 获取：车辆品牌类型
	 */
    public Integer getCarPinpaiTypes() {
        return carPinpaiTypes;
    }


    /**
	 * 设置：车辆品牌类型
	 */
    public void setCarPinpaiTypes(Integer carPinpaiTypes) {
        this.carPinpaiTypes = carPinpaiTypes;
    }
    /**
	 * 获取：车牌号
	 */
    public String getCarPaiNumber() {
        return carPaiNumber;
    }


    /**
	 * 设置：车牌号
	 */
    public void setCarPaiNumber(String carPaiNumber) {
        this.carPaiNumber = carPaiNumber;
    }
    /**
	 * 获取：车辆照片
	 */
    public String getCarPhoto() {
        return carPhoto;
    }


    /**
	 * 设置：车辆照片
	 */
    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }
    /**
	 * 获取：是否在使用
	 */
    public Integer getCarYesnoTypes() {
        return carYesnoTypes;
    }


    /**
	 * 设置：是否在使用
	 */
    public void setCarYesnoTypes(Integer carYesnoTypes) {
        this.carYesnoTypes = carYesnoTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
