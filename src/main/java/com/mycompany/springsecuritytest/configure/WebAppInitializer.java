/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecuritytest.configure;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author COSH
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
                return new Class[]{};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
                return new Class[]{WebConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
                return new String[] { "/" };
        }

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
                super.onStartup(servletContext); 
                FilterRegistration.Dynamic  encodingFilter  = servletContext.
                        addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
                encodingFilter.setInitParameter("encoding", "UTF-8");
                encodingFilter.setInitParameter("forceEencoding", "true");
                encodingFilter.addMappingForUrlPatterns(null, true, "/*");
        }
        
        
        
        
}
