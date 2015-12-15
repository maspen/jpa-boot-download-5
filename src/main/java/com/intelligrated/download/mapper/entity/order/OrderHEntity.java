package com.intelligrated.download.mapper.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.IEntity;

/**
 * from EasyPickDB_Structure_final.sql
 * 
 * "This table contains information about the sub-orders that are generated
by filetodb."
 * 
 * 
 * @author matt.aspen
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = OrderHEntity.tableName)
public class OrderHEntity extends AbstractEntity implements IEntity {
	public static final String tableName = "orderh";
	
	@Column(name = "seq_num")
	private Integer sequenceNumber; // is == to header's sequenceNumber
	
	@Column(name = "misc_field_1")
	private String miscField1;
	
	@Column(name = "slot_name")
	private String slotName;
	
	@Column(name = "sku_code")
	private String skuCode;

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
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
