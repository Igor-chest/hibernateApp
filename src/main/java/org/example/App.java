package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) { // try с ресурсами после выполнения сам закроет sessionFactory

            session.beginTransaction();

            //Actor actor = session.get(Actor.class, 1);
            //System.out.println(actor.getMovies());

            //Movie movie = actor.getMovies().get(0);
            //System.out.println(movie);

            //Actor actor = new Actor("test1", 22);
            //session.save(actor);

            //Actor actor = session.get(Actor.class, 3);
            //session.delete(actor);

            //session.createQuery("update Actor set name='H. Keitel' where name like '%Keitel%'").executeUpdate();


            //actor.getMovies().remove(0);
            //movie.getActors().remove(actor);

            /*Actor actor1 = new Actor("Marlon Brando", 80);
            Actor actor2 = new Actor("Al Pachino", 83);
            Actor actor3 = new Actor("James Kaan", 82);

            Movie movie = new Movie("Godfather", 1972);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2, actor3)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor3.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(movie);*/

            //session.createQuery("delete from Person where age < 500").executeUpdate();

            //Person person = new Person("Tom", 40);
            //session.save(person);

            //Item item1 = new Item("Book", person);
            //Item item2 = new Item("Airpods", person);
            //Item item3 = new Item("Iphone", person);

            //person.setItems(new ArrayList<>(List.of(item1, item2, item3)));

            //session.save(person);



            session.getTransaction().commit(); // закрываем транзакцию

        }
    }
}
