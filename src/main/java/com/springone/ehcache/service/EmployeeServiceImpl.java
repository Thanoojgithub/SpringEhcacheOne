package com.springone.ehcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.springone.ehcache.vo.Employee;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	@CacheEvict(value = "emp", key = "#id")
	public void cacheEvictOfEmployee(Integer id) {
		System.out.println("inside cacheEvictOfEmployee method :: @CacheEvict");
	}

	@Override
	@Cacheable(value = "emp", key = "#id")
	public Employee getEmployee(Integer id) {
		System.out.println("inside getEmployee method :: @Cacheable");
		return new Employee(id, "sriram");
	}

}
