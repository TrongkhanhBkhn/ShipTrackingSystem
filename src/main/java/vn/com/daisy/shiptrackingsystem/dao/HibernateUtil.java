package vn.com.daisy.shiptrackingsystem.dao;

//import java.io.File;

///import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// String workingDir = System.getProperty("user.dir");
				// File file = null;
				//
				// if (workingDir.contains("\\")) {
				//
				// file = new File(workingDir + "\\hibernate.cfg.xml");
				// }
				// if (workingDir.contains("/")) {
				// file = new File(workingDir + "/hibernate.cfg.xml");
				// }
				sessionFactory = new Configuration()
						.configure(
								"/vn/com/daisy/shiptrackingsystem/hibernateconfig/hibernate.cfg.xml")
						.buildSessionFactory();
				// sessionFactory = new
				// Configuration().configure(file).buildSessionFactory();
				System.err.println("Connect to database successful");
			} catch (Exception ex) {
				// Make sure you log the exception, as it might be swallowed
				System.err.println("sessionFactory error " + ex);
				System.err
						.println("Cannot connect to database. Connect refuse!!!");
				System.exit(1);
			}
		}

		return sessionFactory;
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}
}
