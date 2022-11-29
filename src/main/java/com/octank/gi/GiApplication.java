package com.octank.gi;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import java.net.Inet6Address;

import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


@SpringBootApplication
@RestController
public class GiApplication {
	
	
	 @Autowired
	    private ServerProperties serverProperties;

	    @PostConstruct
	    public void init() throws Exception {
	        serverProperties.setAddress(getClientInetAddress());
	    }

	    InetAddress getClientInetAddress() throws Exception {
	        List<String> interfaces = Arrays.asList("eth0", "en0", "eth1", "en1", "eth2", "en2", "eth3", "en3", "wlan0");
	        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
	        for (NetworkInterface networkInterface : Collections.list(nets)) {
	            if (interfaces.contains(networkInterface.getName())) {
	                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
	                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
	                    if (!inetAddress.isAnyLocalAddress() && !(inetAddress instanceof Inet6Address)) {
	                        return inetAddress;
	                    }
	                }
	            }
	        }
	        return InetAddress.getLocalHost();
	    }
	
    public static void main(String[] args) {
    
    	
    SpringApplication.run(GiApplication.class, args);
    }
    
  
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "") String name) {
    	
    try {
		java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();

	  	
       return String.format("Welcome to Octank General Insurance Website running on !"+localMachine  , name);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return name;
    }
    
    
    
  
}
