package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};


@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "YBW";
	}
	
	@Bean
	public int age() {
		return 300;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Sergio", 28, new Address("Main", "CDMX"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address() ); // name, age Bean으로 만들기!
		return person;
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address myAddressBean) { // name age myAddressBean - bean 이름으로 ...
		// 주입하기.
		var person = new Person(name, age, myAddressBean ); // name, age Bean으로 만들기!
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) { // name age myAddressBean - bean 이름으로 ...
		// 주입하기.
		var person = new Person("dd", age, address ); // name, age Bean으로 만들기!
		return person;
	}
	
	@Bean
	@Primary
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { // name age myAddressBean - bean 이름으로 ...
		// 주입하기.
		var person = new Person("dd", age, address ); // name, age Bean으로 만들기!
		return person;
	}
	
	
	
	@Bean(name="myAddressBean")
	@Primary
	public Address address() {
		var address = new Address("1111-2222", "의정부");
		return address;
	}
	
	@Bean(name="myAddressBean2")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("2222-2222", "의정부");
		return address;
	}
}
