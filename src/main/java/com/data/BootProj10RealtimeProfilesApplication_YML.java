package com.data;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.data.controller.EmployeeOperationsController;
import com.data.model.Employee;

@SpringBootApplication(exclude = JdbcTemplateAutoConfiguration.class)
public class BootProj10RealtimeProfilesApplication_YML {
	
	
	
	/*	@Bean
		public   ComboPooledDataSource   createC3P0Ds()throws Exception {
		  ComboPooledDataSource   ds=new ComboPooledDataSource();
		  ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		  ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		  ds.setUser("system"); ds.setPassword("manager");
		  return ds;
		}*/

	public static void main(String[] args) {
		   //get  IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj10RealtimeProfilesApplication_YML.class, args);
		  //get access to controller class obj
		EmployeeOperationsController controller=ctx.getBean("empController",EmployeeOperationsController.class);
		// invoke the b.method
		try {
			List<Employee> list=controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem is code ::"+e.getMessage());
		}
		
		//close the IOC container
		((ConfigurableApplicationContext) ctx).close();
		
		
	}

}
