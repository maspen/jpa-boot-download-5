package com.intelligrated.download.mapper.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.IEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = OrderLEntity.tableName)
public class OrderLEntity extends AbstractEntity implements IEntity {
	public static final String tableName = "orderl";
	
	@Column(name = "seq_num")
	private Integer sequenceNumber; // is == to header's sequenceNumber
	
	@Column(name = "sku_description")
	private String skuDescription;
	
	@Column(name = "cust_sku_desc")
	private String custSkuDesc;
	
	@Column(name = "cust_sku_upc")
	private String custSkuUpc;
	
	@Column(name = "q_ordered")
	private Integer qOrdered;
	
	@Column(name = "misc_Field_2")
	private String miscField2;
	
	@Column(name = "misc_field_3")
	private String miscField3;
	
	@Column(name = "misc_field_4")
	private String miscField4;
	
	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public String getCustSkuDesc() {
		return custSkuDesc;
	}

	public void setCustSkuDesc(String custSkuDesc) {
		this.custSkuDesc = custSkuDesc;
	}

	public String getCustSkuUpc() {
		return custSkuUpc;
	}

	public void setCustSkuUpc(String custSkuUpc) {
		this.custSkuUpc = custSkuUpc;
	}

	public Integer getqOrdered() {
		return qOrdered;
	}

	public void setqOrdered(Integer qOrdered) {
		this.qOrdered = qOrdered;
	}

	public String getMiscField2() {
		return miscField2;
	}

	public void setMiscField2(String miscField2) {
		this.miscField2 = miscField2;
	}

	public String getMiscField3() {
		return miscField3;
	}

	public void setMiscField3(String miscField3) {
		this.miscField3 = miscField3;
	}

	public String getMiscField4() {
		return miscField4;
	}

	public void setMiscField4(String miscField4) {
		this.miscField4 = miscField4;
	}

	public static String getTablename() {
		return tableName;
	}
}
