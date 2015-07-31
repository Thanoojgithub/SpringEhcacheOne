package com.springone.ehcache.app;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springone.ehcache.javaconfig.JavaConfig;
import com.springone.ehcache.service.EmployeeService;

public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private final static Random random = new Random();

	public static Random getRandom() {
		return random;
	}

	public static Integer generateRandomInteger(Integer amount) {
		return getRandom().nextInt(amount);
	}

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
			log.info("JavaConfig spring with Ehcache - starts");
			EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
			Integer generateRandomInteger = generateRandomInteger(15);
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			log.info("cached values!!");
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			
			log.info("now cacheEvicting!!");
			employeeService.cacheEvictOfEmployee(generateRandomInteger);
			generateRandomInteger = generateRandomInteger(15);
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			
			log.info("now cacheEvicting!!");
			employeeService.cacheEvictOfEmployee(generateRandomInteger);
			generateRandomInteger = generateRandomInteger(15);
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			log.info("Employee :: " + employeeService.getEmployee(generateRandomInteger));
			
			log.info("JavaConfig spring with Ehcache - ends");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
