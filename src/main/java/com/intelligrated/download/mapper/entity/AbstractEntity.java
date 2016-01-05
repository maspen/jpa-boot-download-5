package com.intelligrated.download.mapper.entity;

import java.lang.reflect.Field;

/**
 * Common implementation for Entity classes
 * 
 * @author matt.aspen
 */
public abstract class AbstractEntity {

	/**
	 * Gets the {@link Field} for an entity
	 * 
	 * @param fieldName the String name of the field. In the legacy application, db field names
	 * can contain underscores which need to be removed since java field names do not
	 * 
	 * @return Field for an entity with this fiel name
	 */
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
}
