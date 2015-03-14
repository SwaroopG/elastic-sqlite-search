package com.poorjar.sqlite.hibernate.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Contains utility methods
 * @author srccodes.com
 * @version 1.0
 */
public class HibernateUtil
{
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException
    {
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    // We need to configure session factory once.
    // Rest of the time we will get session using the same.
    static
    {
        configureSessionFactory();
    }

    private HibernateUtil()
    {
    }

    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}