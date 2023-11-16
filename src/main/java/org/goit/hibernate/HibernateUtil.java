package org.goit.hibernate;

import org.goit.entities.Client;
import org.goit.entities.Planet;
import org.goit.entities.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements AutoCloseable{
    private static final HibernateUtil INSTANCE;
    private final SessionFactory factory;

    private HibernateUtil(){
        factory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    static {
        INSTANCE = new HibernateUtil();
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }

    public SessionFactory getFactory(){
        return factory;
    }

    @Override
    public void close(){
        factory.close();
    }
}
