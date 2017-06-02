package com.fdmgroup.app;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.service.Customer;
import com.fdmgroup.service.GreetFactory;
import com.fdmgroup.service.GreetService;
import com.fdmgroup.service.Messenger;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//GreetService greet = (GreetService)context.getBean("greet");
		//GreetFactory greet = context.getBean("greet", GreetFactory.class);
		GreetService greet = context.getBean("greet", GreetService.class);
		GreetService greet1 = context.getBean("greet1", GreetService.class);
		GreetService greet2 = context.getBean("greet2", GreetService.class);
		//System.out.println(greet.toString());
		greet.say();
		greet1.say();
		greet2.say();
		System.out.println("------------------------");
		Messenger messenger = context.getBean("messenger",Messenger.class);
		messenger.sendMessage("david@bowie.com", "Hello David! Hope everything is fine with you");
		
		System.out.println("------------------------");
		Customer customer = context.getBean("customer", Customer.class);
		System.out.println(customer.getPerson().getOldAddresses().getClass());
		System.out.println(customer.getPerson());
		System.out.println(customer.getOrderType());
		for (String address : customer.getPerson().getOldAddresses()) {
			System.out.println(address);
		}

		System.out.println("------");
		System.out.println(customer.getPerson().getCreditCardNumbers().getClass());
		for (String numbers : customer.getPerson().getCreditCardNumbers()) {
			System.out.println(numbers);
		}

		System.out.println("----______--");
		System.out.println(customer.getPerson().getGrades().getClass());
		Set<String> keys = customer.getPerson().getGrades().keySet();
		for (String key : keys) {
			System.out.println(key+": "+customer.getPerson().getGrades().get(key));
		}
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
