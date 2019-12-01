package com.tony_funny.api.output;

import java.util.List;

import com.tony_funny.dto.NewDTO;

public class NewOutput {

	private int page;
	private int totalPage;
	private List<NewDTO> listTotal;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<NewDTO> getListTotal() {
		return listTotal;
	}
	public void setListTotal(List<NewDTO> listTotal) {
		this.listTotal = listTotal;
	}
	
}
