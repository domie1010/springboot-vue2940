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
 * 订单
 *
 * @author 
 * @email
 */
@TableName("car_order")
public class CarOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CarOrderEntity() {

	}

	public CarOrderEntity(T t) {
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
     * 单号
     */
    @TableField(value = "car_danhao_number")

    private String carDanhaoNumber;


    /**
     * 司机
     */
    @TableField(value = "siji_id")

    private Integer sijiId;


    /**
     * 车辆
     */
    @TableField(value = "car_id")

    private Integer carId;


    /**
     * 商品名字
     */
    @TableField(value = "shangpin_name")

    private String shangpinName;


    /**
     * 商品数量
     */
    @TableField(value = "shangpin_number")

    private Integer shangpinNumber;


    /**
     * 运输价格
     */
    @TableField(value = "yunshu_money")

    private Double yunshuMoney;


    /**
     * 出行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chuxing_time",fill = FieldFill.UPDATE)

    private Date chuxingTime;


    /**
     * 订单状态
     */
    @TableField(value = "car_order_yesno_types")

    private Integer carOrderYesnoTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：单号
	 */
    public String getCarDanhaoNumber() {
        return carDanhaoNumber;
    }


    /**
	 * 获取：单号
	 */

    public void setCarDanhaoNumber(String carDanhaoNumber) {
        this.carDanhaoNumber = carDanhaoNumber;
    }
    /**
	 * 设置：司机
	 */
    public Integer getSijiId() {
        return sijiId;
    }


    /**
	 * 获取：司机
	 */

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCarId() {
        return carId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    /**
	 * 设置：商品名字
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 获取：商品名字
	 */

    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 设置：商品数量
	 */
    public Integer getShangpinNumber() {
        return shangpinNumber;
    }


    /**
	 * 获取：商品数量
	 */

    public void setShangpinNumber(Integer shangpinNumber) {
        this.shangpinNumber = shangpinNumber;
    }
    /**
	 * 设置：运输价格
	 */
    public Double getYunshuMoney() {
        return yunshuMoney;
    }


    /**
	 * 获取：运输价格
	 */

    public void setYunshuMoney(Double yunshuMoney) {
        this.yunshuMoney = yunshuMoney;
    }
    /**
	 * 设置：出行时间
	 */
    public Date getChuxingTime() {
        return chuxingTime;
    }


    /**
	 * 获取：出行时间
	 */

    public void setChuxingTime(Date chuxingTime) {
        this.chuxingTime = chuxingTime;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getCarOrderYesnoTypes() {
        return carOrderYesnoTypes;
    }


    /**
	 * 获取：订单状态
	 */

    public void setCarOrderYesnoTypes(Integer carOrderYesnoTypes) {
        this.carOrderYesnoTypes = carOrderYesnoTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "CarOrder{" +
            "id=" + id +
            ", carDanhaoNumber=" + carDanhaoNumber +
            ", sijiId=" + sijiId +
            ", carId=" + carId +
            ", shangpinName=" + shangpinName +
            ", shangpinNumber=" + shangpinNumber +
            ", yunshuMoney=" + yunshuMoney +
            ", chuxingTime=" + chuxingTime +
            ", carOrderYesnoTypes=" + carOrderYesnoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
