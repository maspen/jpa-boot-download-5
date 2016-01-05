package com.intelligrated.download.mapper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = MapperEntity.tableName)
public class MapperEntity implements IEntity, Serializable {
	private static final long serialVersionUID = -2625417579365514510L;

	public static final String tableName = "mappers";
	
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * Added column so its easier to differentiate
	 * b/w the 'types' of Entities in an download file
	 * 1 = header, 2 = order line, ... 
	 */
	@Column(name = "entity_type")
	private Integer entityType;
	
	@Column(name = "field_name")
	private String fieldName;
	
	@Column(name = "field_title")
	private String fieldTitle;
	
	@Column(name = "field_tab_name")
	private String fieldTableName;

	@Column(name = "index_start")
	private Integer indexStart;
	
	@Column(name = "index_length")
	private Integer indexLength;
	
	@Column(name = "data_type")
	private String dataType;
	
	@Column(name = "record_code")
	private String recordCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldTitle() {
		return fieldTitle;
	}

	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}

	public String getFieldTableName() {
		return fieldTableName;
	}

	public void setFieldTableName(String fieldTableName) {
		this.fieldTableName = fieldTableName;
	}

	public Integer getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(Integer indexStart) {
		this.indexStart = indexStart;
	}

	public Integer getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(Integer indexLength) {
		this.indexLength = indexLength;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}
}
