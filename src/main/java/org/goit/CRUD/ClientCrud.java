package org.goit.CRUD;

import org.goit.entities.Client;
import org.goit.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ClientCrud {
    private final SessionFactory factory = HibernateUtil.getInstance().getFactory();

    public void save(Client entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }
    }


    public Client findById(long id) {
        try(Session session = factory.openSession()){
             return session.get(Client.class, id);
        }
    }


    public void update( Client entity) {
        try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.merge(entity);
                tx.commit();
        }
    }


    public void delete(Client entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }
    }
}
