package com.boxy.showcase.service;

import java.util.List;

public class PagedList<T> {
	//总记录数
	private long total;
	//总页数
	private int pageCount;
	//第几页
	private int pageIndex;
	//每页记录数
	private int pageSize;
	//当前页数据
	private List<T> pages;
	
	public PagedList(int pageIndex, int pageSize, long totalCount, List<T> pages){
		this.total = totalCount;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		// 根据总记录数计算总页数
		this.pageCount = (int)((totalCount - 1)/pageSize + 1);
		this.pages = pages;
		
		this.pageIndex = Math.max(this.pageIndex, 1);
		this.pageIndex = Math.min(this.pageIndex, this.pageCount);
	}

	/**
	 * 总记录数
	 * @return
	 */
	public long getTotal(){
		return total;
	}
	
	/**
	 * 总页数
	 * @return
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 每页大小
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 当前页
	 * @return
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 当前页数据
	 * @return
	 */
	public List<T> getPages() {
		return pages;
	}
	
	/**
	 * 首页
	 * @return
	 */
	public int getFirst() {
		return 1;
	}
	
	/**
	 * 前一页
	 * @return
	 */
	public int getPrev(){
		return Math.max(pageIndex-1, 1);
	}
	
	/**
	 * 后一页
	 * @return
	 */
	public int getNext(){
		return Math.min(pageIndex+1, pageCount);
	}
	
	/**
	 * 尾页
	 * @return
	 */
	public int getLast(){
		return pageCount;
	}
}
