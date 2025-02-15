package com.in28minutes.learn_spring_framework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		// 1. Launch a Spring Context - 
		
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// 2. Configure the things that we want Spring to manage - @Configuration
		// HelloWorldConfiguration
		// name - @Bean 
		
		// 3. Retrieving Beans managed by Spring
		System.out.println(context.getBean("name")); // YBW
		
		System.out.println(context.getBean("age") + "살인듯?"); // 300
		
		System.out.println(context.getBean("person"));
		
		System.out.println(context.getBean("myAddressBean"));
		
		System.out.println(context.getBean("person2MethodCall"));
		
		System.out.println(context.getBean("person3Parameters"));
		
		System.out.println(context.getBean("person4Parameters"));
		
		System.out.println(context.getBean("person5Qualifier"));
		// context를 이용해서 모든 Bean 불러오기
		
//		Arrays.stream(context.getBeanDefinitionNames())
//			.forEach(System.out::println);
	}

}
