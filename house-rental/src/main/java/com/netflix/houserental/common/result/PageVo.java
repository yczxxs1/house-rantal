package com.netflix.houserental.common.result;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public class PageVo<T> {
	private Integer page;
	private Integer size;
	private Integer lastPage;
	private Long total;
	private List<T> list;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageVo(PageInfo<T> pageinfo) {
		super();
		this.page = pageinfo.getPageNum();
		this.size = pageinfo.getPageSize();
		this.lastPage = pageinfo.getNavigateLastPage();
		this.total = pageinfo.getTotal();
		this.list =  pageinfo.getList();
	}
	
	public PageVo(Page<T> pageinfo) {
		super();
		this.page = pageinfo.getPageNum();
		this.size = pageinfo.getPageSize();
		this.lastPage = pageinfo.getPages();
		this.total = pageinfo.getTotal();
		this.list =  pageinfo.getResult();
	}

	public PageVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
