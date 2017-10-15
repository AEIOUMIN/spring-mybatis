package com.boxy.showcase.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boxy.showcase.mapper.GenericMapper;
import com.boxy.showcase.service.GenericService;
import com.boxy.showcase.service.PagedList;

@Transactional
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK>{
	@Autowired
	protected GenericMapper<T, PK> genericMapper;
	
	@Override
	public void add(T t) {
		genericMapper.add(t);
	}

	@Override
	public void update(T t) {
		genericMapper.update(t);
	}

	@Override
	public void delete(PK id) {
		genericMapper.delete(id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(String[] ids) {
		for(String id : ids){
			genericMapper.delete((PK)Integer.valueOf(id));
		}
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	@Override
	public T find(PK id) {
		return genericMapper.find(id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public T findByName(String name) {
		return genericMapper.findByName(name);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public PagedList<T> findPage(int pageIndex, int pageSize) {
		long totalCount = genericMapper.totalCount();
		List<T> pages = genericMapper.findPage((pageIndex-1)*pageSize, pageSize);
		return new PagedList<T>(pageIndex, pageSize, totalCount, pages);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public List<T> findAll() {
		return genericMapper.findAll();
	}
}
