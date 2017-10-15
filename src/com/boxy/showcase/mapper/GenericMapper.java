package com.boxy.showcase.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 实现基本的增删改查功能（包含分页，不包含条件查询）
 * @author Administrator
 * @param <T>
 * @param <PK>
 */
public interface GenericMapper<T, PK extends Serializable> {
	void add(T t);
	void update(T t);
	void delete(PK id);
	
	T find(PK id);
	T findByName(String name);
	
	long totalCount();
	List<T> findPage(@Param("firstResult")int firstResult, @Param("maxResult")int maxResult);
	List<T> findAll();
}
