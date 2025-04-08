package com.entity.view;

import com.entity.CarEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("car")
public class CarView extends CarEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 车辆类型的值
		*/
		private String carValue;
		/**
		* 车辆品牌类型的值
		*/
		private String carPinpaiValue;
		/**
		* 是否在使用的值
		*/
		private String carYesnoValue;



	public CarView() {

	}

	public CarView(CarEntity carEntity) {
		try {
			BeanUtils.copyProperties(this, carEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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









}
