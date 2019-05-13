package test.dao;

import test.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDAOImpl implements PartDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Part> PartsList(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Part").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(part);
    }

    @Override
    public void delete(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);
    }

    @Override
    public void edit(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.update(part);
    }

    @Override
    public Part getId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Part.class, id);
    }

    @Override
    public int partsCount() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT (*) FROM Part";
        return session.createQuery(hql, Number.class).getSingleResult().intValue();
    }

    @Override
    public List<Part> search(String query) {
        return null;
    }

    @Override
    public List<Part> allNecessity() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Part WHERE necessity = true ";
        return session.createQuery(hql).list();
    }
}
