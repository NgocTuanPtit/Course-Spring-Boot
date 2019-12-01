package com.tony_funny.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<NewEntity> newEntities;
	
	public List<NewEntity> getNewEntities() {
		return newEntities;
	}

	public void setNewEntities(List<NewEntity> newEntities) {
		this.newEntities = newEntities;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
