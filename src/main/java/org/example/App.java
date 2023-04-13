package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1); // получаем сущность по id через сессию из бд через транзакцию
            System.out.println(person.getName());
            System.out.println(person.getAge());

            session.getTransaction().commit(); // закрываем транзакцию
        } finally {
            sessionFactory.close();
        }

    }
}
