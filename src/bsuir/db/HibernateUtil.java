package bsuir.db;

import bsuir.entity.Model;
import bsuir.entity.Ship;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Collection<Model> getModels() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Model> result = session.createQuery("from Model").list();
        session.getTransaction().commit();
        return result;
    }

    public static Model getModelById(int id) {
        Model model = null;
        try (Session session = getSessionFactory().openSession()) {
            model = session.get(Model.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static void updateModel(int id, String modelField, int seats) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Model model = session.get(Model.class, id);
            model.setName(modelField);
            model.setCargoSeats(seats);
            session.update(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public static void addModel(String modelField, int seats) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Model model = Model.newBuilder()
                    .setCargoSeats(seats)
                    .setName(modelField)
                    .build();
            session.save(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public static void deleteModel(int idModel) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Model model = session.get(Model.class, idModel);
            session.delete(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static Collection<Ship> getShips() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Ship> result = session.createQuery("from Ship").list();
        session.getTransaction().commit();
        return result;
    }

    public static Ship getShipById(String id) {
        Ship ship = null;
        try (Session session = getSessionFactory().openSession()) {
            ship = session.get(Ship.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return ship;
    }

    public static void updateShip(String shipId, int idModel) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Ship ship = session.get(Ship.class, shipId);
            Model model = session.get(Model.class, idModel);
            ship.setModel(model);
            session.update(ship);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public static void addShip(String idShip, int idModel) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Model model = session.get(Model.class, idModel);
            Ship ship = new Ship(idShip, model);
            session.save(ship);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public static void deleteShip(String idShip) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Ship ship = session.get(Ship.class, idShip);
            session.delete(ship);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
