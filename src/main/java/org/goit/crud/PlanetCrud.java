package org.goit.CRUD;

import org.goit.entities.Planet;
import org.goit.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrud {
    private final SessionFactory factory = HibernateUtil.getInstance().getFactory();

    public void save(Planet entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }
    }


    public Planet findById(long id) {
        try(Session session = factory.openSession()){
            return session.find(Planet.class, id);
        }
    }


    public void update(Planet entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        }
    }


    public void delete(Planet entity) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }
    }
}
