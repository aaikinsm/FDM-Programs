package com.fdmgroup.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fdmgroup.service.Scooter;

@Configuration
@ComponentScan(value = {"com.fdmgroup.service"})
public class DiConfigurator {

	@Bean(name="scooter")
	public Scooter getScooter(){
		Scooter sc = new Scooter();
		return sc;
	}
	
	@Bean(name = "company")
	public List<String>  getCompanies(){
		List<String> companies = new ArrayList<>();
		companies.add("Honda");
		companies.add("Toyota");
		return companies;
	}
}
