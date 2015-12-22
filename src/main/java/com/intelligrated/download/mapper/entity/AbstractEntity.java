package com.intelligrated.download.mapper.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@MappedSuperclass
public class AbstractEntity implements Serializable {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", nullable = false, unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//@SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)  
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")	
	// Replace mytable_id_seq with the name of the sequence that generates your id.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	// TODO: equals, hash code
	
	// for setting in MapperService, need way to pull the 'field_title'
	// from the entity mapper
	public Field getField(String fieldName) {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(field.getName().equalsIgnoreCase(fieldName.replace("_", ""))) {
				field.setAccessible(true);
				return field;
			}
		}
		return null;
	}
	
	public Object getFieldType(Field field) {
		return field.getType();
	}
}
