package com.bookmyfurniture.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bookmyfurniture.entity.Profile;


public class DbConnection {

	private Session createDbConnection() {
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}

	public void verifyRegisteredUserDataInDb(Profile signedUpUserProfile) {
		Session session = null;
		try {
			session = createDbConnection();
			session.beginTransaction();
			Profile retrivedUserProfile = session.createQuery("From Profile p where p.emailId=:email_id", Profile.class)
					.setParameter("email_id", signedUpUserProfile.getEmail_id()).getSingleResult();
			// List<Profile> query = session.createQuery("FROM
			// Profile",Profile.class).getResultList();
			// System.out.println(query);
			// retrivedUserProfile.setParameter("emailID", );
			// for(Object l : retrivedUserProfile){
			System.out.println("Match found :  " + retrivedUserProfile.toString());
			// }
			if (signedUpUserProfile.equals(retrivedUserProfile)) {
				System.out.println("data found");
			} else {
				System.out.println("Not found");
			}
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

