package com.intelligrated.download.mapper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents the eporder table (or subset) with fields (called 'field title'):
 * 
 * comment_1|comment_2|dl_batch|c_order_nbr|misc_field_1|comment_3|comment_4|comment_5|comment_6|comment_8|order_nbr|carton_id|misc_int1|misc_field_2|misc_field_3|comment_9
 * 
 * @author matt.aspen
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = EPOrder.tableName)
public class EPOrder extends AbstractEntity {
	public static final String tableName = "eporder";
	
	/** these are "field title"s */
	@Column(name = "comment_1")
	private String comment1;
	
	@Column(name = "comment_2")
	private String comment2;
	
	@Column(name = "dl_batch")
	private String dlBatch;
	
	@Column(name = "c_order_nbr")
	private String cOrderNumber;
	
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
	private String orderNumber;
	
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
	
	
}
