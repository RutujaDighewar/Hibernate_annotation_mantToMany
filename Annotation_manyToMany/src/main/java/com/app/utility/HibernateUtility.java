package com.app.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.entity.Certifications;
import com.app.entity.Employee;

public class HibernateUtility {

	public static SessionFactory getSession() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/HiberManyToMany");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		Configuration cfg=new Configuration();
		cfg.setProperties(properties);
		
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Certifications.class);
		
		StandardServiceRegistryBuilder  registryBuilder= new StandardServiceRegistryBuilder();
		registryBuilder.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry=registryBuilder.build();
		
		SessionFactory sessionFactory=cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
}
