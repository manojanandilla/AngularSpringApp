package com.xvitcoder.angularspringapp.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		servletContext.addListener(new ContextLoaderListener(context));
		

		Dynamic servlet = servletContext.addServlet("DispatcherServlet",
				new org.springframework.web.servlet.DispatcherServlet());
		
		servlet.setInitParameter("contextConfigLocation","/WEB-INF/spring/webapp-config.xml");
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
