package com.gcf.common.bean;

import java.util.List;

/**
 * 分页
 * 类不能被继承
 * @author Romi.Liu
 *
 */
public final class Page<T> {
	//数据结果
	private List<T> objects;
	
	private int pageSize = 10;
	
	private int pageNum = 1;
	
	public Page(int pageSize, int pageNum,  List<T> objects) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.objects = objects;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
