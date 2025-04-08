package com.entity.model;

import com.entity.CarOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CarOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 单号
     */
    private String carDanhaoNumber;


    /**
     * 司机
     */
    private Integer sijiId;


    /**
     * 车辆
     */
    private Integer carId;


    /**
     * 商品名字
     */
    private String shangpinName;


    /**
     * 商品数量
     */
    private Integer shangpinNumber;


    /**
     * 运输价格
     */
    private Double yunshuMoney;


    /**
     * 出行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuxingTime;


    /**
     * 订单状态
     */
    private Integer carOrderYesnoTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：单号
	 */
    public String getCarDanhaoNumber() {
        return carDanhaoNumber;
    }


    /**
	 * 设置：单号
	 */
    public void setCarDanhaoNumber(String carDanhaoNumber) {
        this.carDanhaoNumber = carDanhaoNumber;
    }
    /**
	 * 获取：司机
	 */
    public Integer getSijiId() {
        return sijiId;
    }


    /**
	 * 设置：司机
	 */
    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCarId() {
        return carId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    /**
	 * 获取：商品名字
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 设置：商品名字
	 */
    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 获取：商品数量
	 */
    public Integer getShangpinNumber() {
        return shangpinNumber;
    }


    /**
	 * 设置：商品数量
	 */
    public void setShangpinNumber(Integer shangpinNumber) {
        this.shangpinNumber = shangpinNumber;
    }
    /**
	 * 获取：运输价格
	 */
    public Double getYunshuMoney() {
        return yunshuMoney;
    }


    /**
	 * 设置：运输价格
	 */
    public void setYunshuMoney(Double yunshuMoney) {
        this.yunshuMoney = yunshuMoney;
    }
    /**
	 * 获取：出行时间
	 */
    public Date getChuxingTime() {
        return chuxingTime;
    }


    /**
	 * 设置：出行时间
	 */
    public void setChuxingTime(Date chuxingTime) {
        this.chuxingTime = chuxingTime;
    }
    /**
	 * 获取：订单状态
	 */
    public Integer getCarOrderYesnoTypes() {
        return carOrderYesnoTypes;
    }


    /**
	 * 设置：订单状态
	 */
    public void setCarOrderYesnoTypes(Integer carOrderYesnoTypes) {
        this.carOrderYesnoTypes = carOrderYesnoTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
