package service;

import dao.PartDAOImpl;
import model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private PartDAOImpl partDAO;

    @Autowired
    public PartServiceImpl(PartDAOImpl partDAO) {
        this.partDAO = partDAO;
    }

    @Override
    @Transactional
    public List<Part> PartsList(int page) {
        return partDAO.PartsList(page);
    }

    @Override
    @Transactional
    public void add(Part part) {
        partDAO.add(part);
    }

    @Override
    @Transactional
    public void delete(Part part) {
        partDAO.delete(part);
    }

    @Override
    @Transactional
    public void edit(Part part) {
        partDAO.edit(part);
    }

    @Override
    @Transactional
    public Part getId(int id) {
        return partDAO.getId(id);
    }

    @Override
    @Transactional
    public int partsCount() {
        return partDAO.partsCount();
    }

    @Override
    @Transactional
    public List<Part> search(String query) {
        return partDAO.search(query);
    }
}
