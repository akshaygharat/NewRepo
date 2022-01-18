package study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDao {
	
	public void addStudent(int roll,String name) {
		Session session = makeSession();
		Transaction t = session.beginTransaction();
		StudentEntity student = new StudentEntity(roll, name);
		session.save(student);
		t.commit();
	}

	private static Session makeSession() {
		//READING the hibernate.cfg.xml  from the classpath 
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources sources = new MetadataSources(registry);
		// Create Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Create SessionFactory
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
		//get new session
		Session session = sessionFactory.openSession(); // start a transaction
		return session;
	} 
}
