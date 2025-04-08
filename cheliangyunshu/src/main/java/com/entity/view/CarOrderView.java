package com.entity.view;

import com.entity.CarOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("car_order")
public class CarOrderView extends CarOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 订单状态的值
		*/
		private String carOrderYesnoValue;



		//级联表 car
			/**
			* 车辆名字
			*/
			private String carName;
			/**
			* 车辆类型
			*/
			private Integer carTypes;
				/**
				* 车辆类型的值
				*/
				private String carValue;
			/**
			* 车辆品牌类型
			*/
			private Integer carPinpaiTypes;
				/**
				* 车辆品牌类型的值
				*/
				private String carPinpaiValue;
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
				* 是否在使用的值
				*/
				private String carYesnoValue;

		//级联表 siji
			/**
			* 司机姓名
			*/
			private String sijiName;
			/**
			* 司机手机号
			*/
			private String sijiPhone;
			/**
			* 司机身份证号
			*/
			private String sijiIdNumber;
			/**
			* 司机照片
			*/
			private String sijiPhoto;
			/**
			* 司机状态
			*/
			private Integer sijiYesnoTypes;
				/**
				* 司机状态的值
				*/
				private String sijiYesnoValue;

	public CarOrderView() {

	}

	public CarOrderView(CarOrderEntity carOrderEntity) {
		try {
			BeanUtils.copyProperties(this, carOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单状态的值
			*/
			public String getCarOrderYesnoValue() {
				return carOrderYesnoValue;
			}
			/**
			* 设置： 订单状态的值
			*/
			public void setCarOrderYesnoValue(String carOrderYesnoValue) {
				this.carOrderYesnoValue = carOrderYesnoValue;
			}





				//级联表的get和set car
					/**
					* 获取： 车辆名字
					*/
					public String getCarName() {
						return carName;
					}
					/**
					* 设置： 车辆名字
					*/
					public void setCarName(String carName) {
						this.carName = carName;
					}
					/**
					* 获取： 车辆类型
					*/
					public Integer getCarTypes() {
						return carTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCarTypes(Integer carTypes) {
						this.carTypes = carTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCarValue() {
							return carValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCarValue(String carValue) {
							this.carValue = carValue;
						}
					/**
					* 获取： 车辆品牌类型
					*/
					public Integer getCarPinpaiTypes() {
						return carPinpaiTypes;
					}
					/**
					* 设置： 车辆品牌类型
					*/
					public void setCarPinpaiTypes(Integer carPinpaiTypes) {
						this.carPinpaiTypes = carPinpaiTypes;
					}


						/**
						* 获取： 车辆品牌类型的值
						*/
						public String getCarPinpaiValue() {
							return carPinpaiValue;
						}
						/**
						* 设置： 车辆品牌类型的值
						*/
						public void setCarPinpaiValue(String carPinpaiValue) {
							this.carPinpaiValue = carPinpaiValue;
						}
					/**
					* 获取： 车牌号
					*/
					public String getCarPaiNumber() {
						return carPaiNumber;
					}
					/**
					* 设置： 车牌号
					*/
					public void setCarPaiNumber(String carPaiNumber) {
						this.carPaiNumber = carPaiNumber;
					}
					/**
					* 获取： 车辆照片
					*/
					public String getCarPhoto() {
						return carPhoto;
					}
					/**
					* 设置： 车辆照片
					*/
					public void setCarPhoto(String carPhoto) {
						this.carPhoto = carPhoto;
					}
					/**
					* 获取： 是否在使用
					*/
					public Integer getCarYesnoTypes() {
						return carYesnoTypes;
					}
					/**
					* 设置： 是否在使用
					*/
					public void setCarYesnoTypes(Integer carYesnoTypes) {
						this.carYesnoTypes = carYesnoTypes;
					}


						/**
						* 获取： 是否在使用的值
						*/
						public String getCarYesnoValue() {
							return carYesnoValue;
						}
						/**
						* 设置： 是否在使用的值
						*/
						public void setCarYesnoValue(String carYesnoValue) {
							this.carYesnoValue = carYesnoValue;
						}











				//级联表的get和set siji
					/**
					* 获取： 司机姓名
					*/
					public String getSijiName() {
						return sijiName;
					}
					/**
					* 设置： 司机姓名
					*/
					public void setSijiName(String sijiName) {
						this.sijiName = sijiName;
					}
					/**
					* 获取： 司机手机号
					*/
					public String getSijiPhone() {
						return sijiPhone;
					}
					/**
					* 设置： 司机手机号
					*/
					public void setSijiPhone(String sijiPhone) {
						this.sijiPhone = sijiPhone;
					}
					/**
					* 获取： 司机身份证号
					*/
					public String getSijiIdNumber() {
						return sijiIdNumber;
					}
					/**
					* 设置： 司机身份证号
					*/
					public void setSijiIdNumber(String sijiIdNumber) {
						this.sijiIdNumber = sijiIdNumber;
					}
					/**
					* 获取： 司机照片
					*/
					public String getSijiPhoto() {
						return sijiPhoto;
					}
					/**
					* 设置： 司机照片
					*/
					public void setSijiPhoto(String sijiPhoto) {
						this.sijiPhoto = sijiPhoto;
					}
					/**
					* 获取： 司机状态
					*/
					public Integer getSijiYesnoTypes() {
						return sijiYesnoTypes;
					}
					/**
					* 设置： 司机状态
					*/
					public void setSijiYesnoTypes(Integer sijiYesnoTypes) {
						this.sijiYesnoTypes = sijiYesnoTypes;
					}


						/**
						* 获取： 司机状态的值
						*/
						public String getSijiYesnoValue() {
							return sijiYesnoValue;
						}
						/**
						* 设置： 司机状态的值
						*/
						public void setSijiYesnoValue(String sijiYesnoValue) {
							this.sijiYesnoValue = sijiYesnoValue;
						}







}
