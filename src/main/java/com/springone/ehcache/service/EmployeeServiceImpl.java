package com.springone.ehcache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.springone.ehcache.vo.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private List<Employee> employees;

	@Override
	@CacheEvict(value = "emp", key="#id")
	public void setEmployee(Integer id) {
		System.out.println("inside setEmployee method");
		getEmployees().add(new Employee(id,"sriram"));
	}

	@Override
	@Cacheable(value="emp", key="#id")
	public List<Employee> getEmployee(Integer id) {
		System.out.println("inside getEmployee method");
		return getEmployees();
	}
	
	public List<Employee> getEmployees() {
		if(employees == null)
			employees = new ArrayList<Employee>();
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
