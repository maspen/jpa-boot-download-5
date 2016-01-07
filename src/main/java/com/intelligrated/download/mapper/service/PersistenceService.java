package com.intelligrated.download.mapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.entity.HeaderEntity;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.Order_H_Entity;
import com.intelligrated.download.mapper.entity.Order_L_Entity;
import com.intelligrated.download.mapper.repo.HeaderRepository;
import com.intelligrated.download.mapper.repo.OrderHRepository;
import com.intelligrated.download.mapper.repo.OrderLRepository;

/**
 * Once entities are created & mapped via the mapper service,
 * this service will persist them
 * 
 * @author matt.aspen
 */
@Service("persistenceService")
public class PersistenceService {
	private final HeaderRepository headerRepository;
	private final OrderHRepository orderHRepository;
	private final OrderLRepository orderLRepository;
	
	@Autowired
	public PersistenceService(HeaderRepository headerRepository, OrderHRepository orderHRepository, OrderLRepository orderLRepository) {
		this.headerRepository = headerRepository;
		this.orderHRepository = orderHRepository;
		this.orderLRepository = orderLRepository;
	}
	
	public void persist(IEntity entity) {
		// TODO: better way of doing this
		if(entity instanceof HeaderEntity) {
			System.out.println("   persisting HeaderEntity");
			headerRepository.save((HeaderEntity)entity);
			
		} else if (entity instanceof Order_H_Entity) {
			System.out.println("   persisting Order_H_Entity");
			orderHRepository.save((Order_H_Entity)entity);
			
		} else if (entity instanceof Order_L_Entity) {
			System.out.println("   persisting Order_L_Entity");
			orderLRepository.save((Order_L_Entity)entity);
			
		} else {
			System.out.println("   unknown entity class " + entity.getClass());
		}
	}
	
	// for sanity check
	public Iterable<HeaderEntity> getHeaders() {
		return headerRepository.findAll();
	}
	
	public Iterable<Order_H_Entity> getOrderH() {
		return orderHRepository.findAll();
	}
	
	public Iterable<Order_L_Entity> getOrderL() {
		return orderLRepository.findAll();
	}
}