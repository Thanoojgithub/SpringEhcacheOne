package com.springone.ehcache.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer Id;
	private String name;
	
	public Employee() {
	}

	public Employee(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + "]";
	}
}
