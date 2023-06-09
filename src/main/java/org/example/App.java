package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main( String[] args ) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        try (sessionFactory) { // try с ресурсами после выполнения сам закроет sessionFactory
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Actor actor = session.get(Actor.class, 1);
            System.out.println(actor.getMovies());

            Movie movie = actor.getMovies().get(0);
            System.out.println(movie);

            //actor.getMovies().remove(0);
            //movie.getActors().remove(actor);

            session.getTransaction().commit(); // закрываем транзакцию

        }
    }
}
