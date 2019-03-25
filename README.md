1. Create Eureka Server
Go to https://start.spring.io/
and 
Search "Eureka Server" in text box:
Search dependencies to add

2. Click on Generate Project 	
3. extract the project and import in eclipse

4. Create class EurekaserverApplication:


package com.test.eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}

}

4. put following in application.yaml by renaming application.properties:

eureka:
   client:
      registerWithEureka: false
      fetchRegistry: false
server:
   port: 8761

   
   
5. Now, hit the URL http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761 as shown below

================================================   
1. Create eureka client:

Go to https://start.spring.io/
and 
Search "Eureka Discovery" in text box:
Search dependencies to add

2. Click on Generate Project 	
3. Extract the project and import in eclipse
4. Create class EurekaClientApplication :

package com.test.eurekaclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		return "Eureka Client application";
	}

}
5. rename application.properties to application.yaml

eureka:
   client:
      serviceUrl:
         defaultZone: http://localhost:8761/eureka
      instance:
      preferIpAddress: true
spring:
   application:
      name: eurekaclient

	  
6. Hit the URL http://localhost:8761/ in your web browser and you can see the Eureka Client application is registered with Eureka Server

Now hit the URL http://localhost:8080/ in your web browser and see the Rest Endpoint output.    
   

================================================   
1. Create Zuul api gateway:

Go to https://start.spring.io/
and 
Search "Zuul" in text box:
Search dependencies to add

2. Click on Generate Project 	
3. Extract the project and import in eclipse
4. rename application.properties to application.yaml and do entry like:

server:
   port: 8111
spring:
   application:  
      name: zuulserver
zuul:

routes:
   products:
      path: /spring-cloud/demo/**
      url: http://localhost:8080/

5. Create class ZuulApplication :

package com.test.zuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}


5. Now, hit the URL http://localhost:8111/spring-cloud/demo/products in your web browser and you can see the output of /products REST Endpoint as shown below 
  
   
=====================
1. Create Config server project

Go to https://start.spring.io/
and 
Search "Config Server" in text box:
Search dependencies to add

2. Click on Generate Project 	
3. Extract the project and import in eclipse
4. in application.properties  do entry like:

server.port = 8888
spring.cloud.config.server.native.searchLocations=file:///C:/configprop/
SPRING_PROFILES_ACTIVE=native


