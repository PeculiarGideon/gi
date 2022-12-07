package com.octank.gi;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GiApplication {
  
    
    public static void main(String[] args) {
    SpringApplication.run(GiApplication.class, args);
    }
    
  
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name) {
    	
    try {
		java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();

	  	
       //return String.format("Welcome to Octank General Insurance Website running on !"+localMachine  , name);
       return String.format("Welcome to Octank General Insurance2 from Server !"+localMachine  , name);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return name;
    }
    
    
    
  
}
