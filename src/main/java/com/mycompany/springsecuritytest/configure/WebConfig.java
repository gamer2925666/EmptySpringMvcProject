/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecuritytest.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;
import tw.org.w3.URIResolver;

/**
 *
 * @author COSH
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.mycompany.springsecuritytest")
public class WebConfig extends WebMvcConfigurerAdapter {
       
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/**")
                        .addResourceLocations("/resource/static/");
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
        }


        
        
        
        @Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver() {
		return new CommonsMultipartResolver();
	}
        
        

	@Bean
	public ViewResolver getXSLTViewResolver() {
		XsltViewResolver xsltResolover = new XsltViewResolver();
		xsltResolover.setOrder(1);
		xsltResolover.setIndent(false);
		xsltResolover.setViewClass(XsltView.class);
		xsltResolover.setPrefix("/resource/template/");
                URIResolver uriResolver = new URIResolver();
                uriResolver.setPrefix("/resource/template/");
                xsltResolover.setUriResolver(uriResolver);
		xsltResolover.setSuffix(".xsl");

		return xsltResolover;
	}

	
        
}
