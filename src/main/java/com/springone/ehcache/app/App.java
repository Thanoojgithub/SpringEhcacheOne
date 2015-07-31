package com.springone.ehcache.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springone.ehcache.javaconfig.JavaConfig;
import com.springone.ehcache.service.EmployeeService;
import com.springone.ehcache.service.EmployeeServiceImpl;

@Component
public class App {

	public static void main(String[] args) {
		final Log log = LogFactory.getLog(App.class);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
			log.info("JavaConfig spring with Ehcache - starts");
			EmployeeService employeeService = new EmployeeServiceImpl();
			employeeService.setEmployee(1);
			System.out.println(employeeService.getEmployee(1));
			System.out.println("cached values!!");
			System.out.println(employeeService.getEmployee(1));
			System.out.println(employeeService.getEmployee(1));
			System.out.println("now cacheEvicting!!");
			employeeService.setEmployee(1);
			System.out.println(employeeService.getEmployee(1));
			log.info("JavaConfig spring with Ehcache - ends");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
