package com.springone.ehcache.service;

import com.springone.ehcache.vo.Employee;

public interface EmployeeService {

	public void cacheEvictOfEmployee(Integer id);

	public Employee getEmployee(Integer id);

}
