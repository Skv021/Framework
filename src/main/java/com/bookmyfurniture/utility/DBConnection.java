package com.bookmyfurniture.utility;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import com.bookmyfurniture.entity.UserProfile;

public class DBConnection {

	private Session createDbConnection() {
		Session session = null;
		try {

			Configuration configuration = new Configuration();
			// System.getProperty("user.dir")+"\\src\\main\\java\\hibernate.cfg.xml"
			/// "D:\\Workspace\\Framework\\DivDemo\\src\\main\\resources\\hibernate.cfg.xml"
			SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
			session = sessionFactory.openSession();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}

	@Test(priority = 1)
	public void verifyRegisteredUserDataInDb() {
		Session session = null;
		try {

			session = createDbConnection();
			session.beginTransaction();
			String qr = "from UserProfile";
			List<UserProfile> query = session.createQuery("from UserProfile", UserProfile.class).getResultList();

			if (query != null) {
				System.out.println(query);
			}
//					for(Object l : list){
//					    System.out.println("L : " +l.toString());
//					}
			session.getTransaction().commit();
			session.close();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
