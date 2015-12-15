package com.intelligrated.download.mapper.entity;

public enum EntityTypeEnum {

	HEADER(1), ORDER_LINE(2), CARTON(3), OTHER(4);
	
	private Integer value;
	
	EntityTypeEnum(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public static EntityTypeEnum parse(Integer value) {
		EntityTypeEnum enumToReturn = null;
		for(EntityTypeEnum item : EntityTypeEnum.values()) {
			if(item.getValue().equals(value)) {
				enumToReturn = item;
				break;
			}
		}
		return enumToReturn;
	}
}
