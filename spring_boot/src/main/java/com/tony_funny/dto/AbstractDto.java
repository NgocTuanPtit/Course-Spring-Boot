package com.tony_funny.dto;

import java.util.Date;
import java.util.List;

public class AbstractDto<T> {

	private Long id;	
	private String createdBy;	
	private Date createdDate;	
	private String modifiedBy;	
	private Date modifiedDate;
	private List<T> listresult;
	
	public List<T> getListresult() {
		return listresult;
	}

	public void setListresult(List<T> listresult) {
		this.listresult = listresult;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
