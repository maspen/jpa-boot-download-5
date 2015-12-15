package com.intelligrated.download.mapper.entity.order;

import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.IEntity;

/**
 * This is not an Entity but a grouping of the tables mentioned
 * in an order line: orderh & orderl
 * 
 * @author matt.aspen
 *
 */
public class OrderEntity implements IEntity {

	private OrderHEntity orderHEntity;
	
	private OrderLEntity orderLEntity;

	public OrderHEntity getOrderHEntity() {
		return orderHEntity;
	}

	public void setOrderHEntity(OrderHEntity orderHEntity) {
		this.orderHEntity = orderHEntity;
	}

	public OrderLEntity getOrderLEntity() {
		return orderLEntity;
	}

	public void setOrderLEntity(OrderLEntity orderLEntity) {
		this.orderLEntity = orderLEntity;
	}
}
