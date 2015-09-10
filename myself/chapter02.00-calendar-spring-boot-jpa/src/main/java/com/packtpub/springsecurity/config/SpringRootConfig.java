
package com.packtpub.springsecurity.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        basePackages = {"com.packtpub.springsecurity"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.packtpub.springsecurity.web.*"}))
@ImportResource("classpath:context/spring-root.xml")
public class SpringRootConfig {


}
