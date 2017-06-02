package com.fdmgroup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"com.fdmgroup.aspect" , "com.fdmgroup.service"})
@EnableAspectJAutoProxy
public class DiConfigurator {

}
