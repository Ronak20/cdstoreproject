package com.cdstore.dbagent.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cdstore.dbagent.model.Address;
import com.cdstore.dbagent.model.CdDrive;
import com.cdstore.dbagent.model.PurchaseOrder;
import com.cdstore.dbagent.model.PurchaseOrderItem;
import com.cdstore.dbagent.model.PurchaseOrderItemId;
import com.cdstore.dbagent.model.VisitEvent;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration()
					.addAnnotatedClass(CdDrive.class)
					.addAnnotatedClass(Address.class)
					.addAnnotatedClass(PurchaseOrder.class)
					.addAnnotatedClass(PurchaseOrderItem.class)
					.addAnnotatedClass(PurchaseOrderItemId.class)
					.addAnnotatedClass(VisitEvent.class)
					.setProperty("hibernate.dialect",
							"org.hibernate.dialect.MySQLDialect")
					.setProperty("hibernate.connection.driver_class",
							"com.mysql.jdbc.Driver")
					.setProperty("hibernate.connection.username", "root")
					.setProperty("hibernate.connection.password", "root")
					.setProperty("hibernate.connection.pool_size", "1")
					.setProperty("hibernate.connection.url",
							"jdbc:mysql://localhost:3306/cdstore")
					.setProperty("hibernate.current_session_context_class",
							"thread")
					.setProperty("hibernate.format_sql", "true")
					.setProperty("hibernate.autoregister_listeners", "false")
					.setProperty("hibernate.show_sql", "true")
					.setProperty("hibernate.connection.autocommit", "true");

			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}