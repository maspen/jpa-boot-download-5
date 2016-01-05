package com.intelligrated.download.mapper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Order_L_Entity.tableName)
public class Order_L_Entity extends AbstractEntity implements IEntity, Serializable {
	private static final long serialVersionUID = 4634354258756785159L;

	public static final String tableName = "orderl";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "seq_num")
	private Integer seqNum; // is == to header's sequenceNumber
	
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

	public Integer getSeqNumber() {
		return seqNum;
	}

	public void setSeqNumber(Integer seqNumber) {
		this.seqNum = seqNumber;
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
}
