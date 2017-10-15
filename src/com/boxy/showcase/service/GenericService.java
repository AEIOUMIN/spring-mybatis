package com.boxy.showcase.service;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型接口（完成增删改查操作）
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericService<T, PK extends Serializable> {
	void add(T t);

	void update(T t);

	void delete(PK id);
	void delete(String[] ids);

	T find(PK id);

	T findByName(String name);

	PagedList<T> findPage(int pageIndex, int pageSize);
	
	List<T> findAll();
}
