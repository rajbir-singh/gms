package com.gms.mysql;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class MySQLConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //kaczmarzyk mysql arguments resolver : https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/
        argumentResolvers.add(new SpecificationArgumentResolver());
    }

}
