
package com.packtpub.springsecurity.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ImportResource("classpath:context/spring-jpa.xml")
public class SpringJPAConfig {

}
