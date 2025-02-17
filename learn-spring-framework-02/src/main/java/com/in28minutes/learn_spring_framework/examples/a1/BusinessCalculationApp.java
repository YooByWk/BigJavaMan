package com.in28minutes.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface DataService {
	int[] retrieveData();
}

@Component
@Primary
class MongoDbDataService implements DataService {

	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}

@Component
@Qualifier("MySQLDataService")
class MySQLDataService implements DataService {

	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
}

@Component
class BusinessCalculationService {

	private DataService dataService;
	
	public BusinessCalculationService( DataService dataService) {
		super();
		System.out.println("이거 씀 " + dataService);
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData())
				.max().orElse(0);
	}
}

@Configuration
@ComponentScan
public class BusinessCalculationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = new AnnotationConfigApplicationContext(BusinessCalculationApp.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			System.out.println(context
					.getBean(BusinessCalculationService.class)
					.findMax());
		}
	}

}
