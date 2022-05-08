package com.example.demo;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller,com.example.demo"})
public class JpaRevisionApplication {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	ApplicationContext context =	SpringApplication.run(JpaRevisionApplication.class, args);
	
	UserInterface userInterface=context.getBean(UserInterface.class);
	
	
	
	}
}
