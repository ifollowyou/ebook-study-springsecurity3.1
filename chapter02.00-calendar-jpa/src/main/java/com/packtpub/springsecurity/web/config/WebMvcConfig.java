package com.packtpub.springsecurity.web.config;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Collections;

/**
 * <p>
 * Here we leverage Spring 3.1's {@link EnableWebMvc} support. This allows more powerful configuration but still be
 * concise about it. Specifically it allows overriding {@link }. Note that this class is
 * loaded via the mvc-config.xml
 * </p>
 * <p>
 * You can find a fairly equivalent Spring MVC configuration below:
 * </p>
 * <p/>
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
 * &lt;beans xmlns=&quot;http://www.springframework.org/schema/beans&quot;
 *     xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;
 *     xmlns:p=&quot;http://www.springframework.org/schema/p&quot;
 *     xmlns:context=&quot;http://www.springframework.org/schema/context&quot;
 *     xmlns:mvc=&quot;http://www.springframework.org/schema/mvc&quot;
 *     xsi:schemaLocation=&quot;http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd
 *         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
 *         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd&quot;&gt;
 *
 *     &lt;mvc:annotation-driven/&gt;
 *     &lt;mvc:resources location=&quot;/resources/&quot; mapping=&quot;/resources/**&quot; cache-period=&quot;31556926&quot;/&gt;
 *     &lt;context:component-scan base-package=&quot;com.packtpub.springsecurity.web.controllers&quot;/&gt;
 *
 *     &lt;bean class=&quot;org.springframework.web.servlet.view.ContentNegotiatingViewResolver&quot;&gt;
 *         &lt;property name=&quot;mediaTypes&quot;&gt;
 *             &lt;map&gt;
 *                 &lt;entry key=&quot;json&quot; value=&quot;application/json&quot;/&gt;
 *             &lt;/map&gt;
 *         &lt;/property&gt;
 *         &lt;property name=&quot;defaultViews&quot;&gt;
 *             &lt;list&gt;
 *                 &lt;bean class=&quot;org.springframework.web.servlet.view.json.MappingJacksonJsonView&quot;
 *                     p:extractValueFromSingleKeyModel=&quot;true&quot;
 *                     p:modelKeys=&quot;#{{'events','event'}}&quot;/&gt;
 *             &lt;/list&gt;
 *         &lt;/property&gt;
 *     &lt;/bean&gt;
 *     &lt;bean class=&quot;org.springframework.web.servlet.view.InternalResourceViewResolver&quot;&gt;
 *         &lt;property name=&quot;prefix&quot; value=&quot;/WEB-INF/views/&quot;/&gt;
 *         &lt;property name=&quot;suffix&quot; value=&quot;.jsp&quot;/&gt;
 *     &lt;/bean&gt;
 * &lt;/beans&gt;
 * </pre>
 *
 * @author Rob Winch
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * We mention this in the book, but this helps to ensure that the intercept-url patterns prevent access to our
     * controllers. For example, once security has been applied for administrators try commenting out the modifications
     * to the super class and requesting <a
     * href="http://localhost:800/calendar/events/.html">http://localhost:800/calendar/events/.html</a>. You will
     * observe that security is bypassed since it did not match the pattern we provided. In later chapters, we discuss
     * how to secure the service tier which helps mitigate bypassing of the URL based security too.
     */


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.favorPathExtension(false).favorParameter(true);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver result = new ContentNegotiatingViewResolver();

        FastJsonJsonView jsonView = new FastJsonJsonView();
        jsonView.setExtractValueFromSingleKeyModel(true);

        result.setDefaultViews(Collections.singletonList((View) jsonView));
        return result;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver internalResolver() {
        InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
        internalResolver.setPrefix("/WEB-INF/views/");
        internalResolver.setSuffix(".jsp");
        return internalResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login/form")
                .setViewName("login");
        registry.addViewController("/errors/403")
                .setViewName("/errors/403");
    }
}
