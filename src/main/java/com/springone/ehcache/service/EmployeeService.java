package com.springone.ehcache.service;

import java.util.List;

import com.springone.ehcache.vo.Employee;

public interface EmployeeService {

	public void setEmployee(Integer id);

	public List<Employee> getEmployee(Integer id);

}
