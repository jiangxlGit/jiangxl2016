package com.jiang.util;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * @功能概要： 用于获取hibernateSession（这里的session和servlet中的session完全不一样）<br>
 * @项目名称： MDOS<br>
 * @初创作者： jiangxl <link 836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-10-25 下午4:43:52<br>
 */

@Entity
public class HibernateSessionFactory {

	/**
	 * 在JDK5.0后，ThreadLocal已经支持泛型
	 * 1、当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的
	 * 变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
	 * 2、而我们每个线程都需要使用他，并且各自使用各自的。这种情况，ThreadLocal就比较好
	 * 的解决了这个问题。
	 * 3、应用场景：当很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候最适
	 * 合使用ThreadLocal。
	 */
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	//定义一个静态的session工厂变量
	private static SessionFactory sessionFactory;
	//new一个静态的配置对象
	private static Configuration configuration = new Configuration();
	/**
	 * 顾名思义, ServiceRegistry 是 Service 的注册表, 它为Service提供了一个统一
	 * 的加载 / 初始化 / 存放 / 获取机制.
	 */
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			/*
			 * configure()方法时会默认在classpath下面（即从src目录下开始查找）
			 * 寻找hibernate.cfg.xml，并进行配置,若没有找到，则抛出异常！
			 */
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			//根据serviceRegistry构建出session工厂
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	private HibernateSessionFactory() {
	}

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 * 返回ThreadLocal会话实例。延迟初始化SessionFactory
	 * @return Session
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}

		return session;
	}

	/**
	 * Rebuild hibernate session factory
	 * 重建hibernate会话工厂
	 */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
	 * Close the single hibernate session instance.
	 * 
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
		}
	}

	/**
	 * return session factory
	 * 
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * return hibernate configuration
	 * 
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}

}