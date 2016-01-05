package com.intelligrated.download.mapper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Order_H_Entity.tableName)
public class Order_H_Entity extends AbstractEntity implements IEntity, Serializable {
	private static final long serialVersionUID = 4634354258756785159L;
	
	public static final String tableName = "orderh";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "seq_num")
	private Integer seqNum; // is == to header's sequenceNumber
	
	@Column(name = "misc_field_1")
	private String miscField1;
	
	@Column(name = "slot_name")
	private String slotName;
	
	@Column(name = "sku_code")
	private String skuCode;

	public Integer getSeqNumber() {
		return seqNum;
	}

	public void setSeqNumber(Integer seqNumber) {
		this.seqNum = seqNumber;
	}

	public String getMiscField1() {
		return miscField1;
	}

	public void setMiscField1(String miscField1) {
		this.miscField1 = miscField1;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
}
