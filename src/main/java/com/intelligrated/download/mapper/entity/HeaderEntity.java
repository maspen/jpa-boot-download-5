package com.intelligrated.download.mapper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = HeaderEntity.tableName)
public class HeaderEntity  implements Serializable {
	private static final long serialVersionUID = 892324898803860497L;
	
	public static final String tableName = "headers";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "seq_num")
	private Integer seqNum;
	
	/** these are "field title"s */
	@Column(name = "comment_1")
	private String comment1;
	
	@Column(name = "comment_2")
	private String comment2;
	
	@Column(name = "dl_batch")
	private String dlBatch;
	
	@Column(name = "c_order_nbr")
	private String cOrderNbr;
	
	@Column(name = "misc_field_1")
	private String miscField1;
	
	@Column(name = "comment_3")
	private String comment3;
	
	@Column(name = "comment_4")
	private String comment4;
	
	@Column(name = "comment_5")
	private String comment5;
	
	@Column(name = "comment_6")
	private String comment6;
	
	@Column(name = "comment_8")
	private String comment8;
	
	@Column(name = "order_nbr")
	private String orderNbr;
	
	@Column(name = "carton_id")
	private String cartonId;
	
	@Column(name = "misc_int1")
	private Integer miscInt1;
	
	@Column(name = "misc_field_2")
	private String miscField2;
	
	@Column(name = "misc_field_3")
	private String miscField3;
	
	@Column(name = "comment_9")
	private String comment9;

	public Long getId() {
		return id;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getDlBatch() {
		return dlBatch;
	}

	public void setDlBatch(String dlBatch) {
		this.dlBatch = dlBatch;
	}

	public String getcOrderNbr() {
		return cOrderNbr;
	}

	public void setcOrderNbr(String cOrderNbr) {
		this.cOrderNbr = cOrderNbr;
	}

	public String getMiscField1() {
		return miscField1;
	}

	public void setMiscField1(String miscField1) {
		this.miscField1 = miscField1;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getComment6() {
		return comment6;
	}

	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}

	public String getComment8() {
		return comment8;
	}

	public void setComment8(String comment8) {
		this.comment8 = comment8;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNumber(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public String getCartonId() {
		return cartonId;
	}

	public void setCartonId(String cartonId) {
		this.cartonId = cartonId;
	}

	public Integer getMiscInt1() {
		return miscInt1;
	}

	public void setMiscInt1(Integer miscInt1) {
		this.miscInt1 = miscInt1;
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

	public String getComment9() {
		return comment9;
	}

	public void setComment9(String comment9) {
		this.comment9 = comment9;
	}

	public static String getTablename() {
		return tableName;
	}
}
