package com.intelligrated.download.mapper.entity;

/**
 * since Application expects a list of Entities
 * and order lines results in creation of 2 Entities (orderh & orderl)
 * AND OrderEntity contains both, there needs to be a way
 * to generalize the types returned from MapperService.
 * 
 * ... not a good way
 * 
 * @author matt.aspen
 *
 */
public interface IEntity {
	
}
