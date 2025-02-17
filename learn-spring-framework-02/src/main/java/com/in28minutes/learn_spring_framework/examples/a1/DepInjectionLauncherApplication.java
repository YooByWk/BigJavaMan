package com.in28minutes.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/// 어떤클래스
@Component
class BusinessClass {
	// 여기에 의존성을 넣자
	Dependency1 dependency1;
	
	Dependency2 dependency2;
	
	// @Autowired // 선택적임~ 
	public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println(" Contstructor Injection on " + this.getClass());
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection -  setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection -  setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
	
}

/// 의존성1 
@Component
class Dependency1 {
	
}
/// 의존성2
@Component
class Dependency2 {
	
}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	
	
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)
		) {
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println(context.getBean(BusinessClass.class));
			
		}
	}

}
