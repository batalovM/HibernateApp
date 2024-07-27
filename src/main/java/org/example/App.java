package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();

        session.beginTransaction();

        List<Person> persons = session.createQuery("from Person where age > 35").getResultList();

        for (Person person : persons) {
            System.out.println(person);
        }

        session.getTransaction().commit();

        sf.close();

    }
}
