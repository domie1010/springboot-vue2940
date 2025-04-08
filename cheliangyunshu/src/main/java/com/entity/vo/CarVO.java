package com.entity.vo;

import com.entity.CarEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("car")
public class CarVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
