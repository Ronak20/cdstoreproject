package com.cdstore.dbagent.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cdstore.dbagent.DbAgentConstant;
import com.cdstore.model.Address;
import com.cdstore.model.CD;
import com.cdstore.model.PurchaseOrder;
import com.cdstore.model.PurchaseOrderItem;
import com.cdstore.model.PurchaseOrderItemId;
import com.cdstore.model.User;
import com.cdstore.model.VisitEvent;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration()
					.addAnnotatedClass(CD.class)
					.addAnnotatedClass(Address.class)
					.addAnnotatedClass(PurchaseOrder.class)
					.addAnnotatedClass(PurchaseOrderItem.class)
					.addAnnotatedClass(PurchaseOrderItemId.class)
					.addAnnotatedClass(VisitEvent.class)
					.addAnnotatedClass(User.class)
					.setProperty("hibernate.dialect",
							"org.hibernate.dialect.MySQLDialect")
					.setProperty("hibernate.connection.driver_class",
							"com.mysql.jdbc.Driver")
					.setProperty("hibernate.connection.username",
							DbAgentConstant.DB_USERNAME)
					.setProperty("hibernate.connection.password",
							DbAgentConstant.DB_PASSWORD)
					.setProperty("hibernate.connection.pool_size", "1")
					.setProperty("hibernate.connection.url",
							DbAgentConstant.DB_CONNECTION_URL)
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