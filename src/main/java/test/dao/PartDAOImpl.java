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

    }

    @Override
    public void edit(Part part) {

    }

    @Override
    public Part getId(int id) {
        return null;
    }

    @Override
    public int partsCount() {
        return 0;
    }

    @Override
    public List<Part> search(String query) {
        return null;
    }
}
