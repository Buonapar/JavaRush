package test.service;

import test.dao.PartDAOImpl;
import test.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
    public List<Part> PartsList(int page, String sorted) {
        return partDAO.PartsList(page, sorted);
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

    @Override
    @Transactional
    public int countPC() {
        List<Part> parts = partDAO.allNecessity();
        int result = parts.get(0).getQuantity();
        for (Part part : parts) {
            if (result > part.getQuantity())
                result = part.getQuantity();
        }
        return result;
    }

    @Override
    @Transactional
    public List<Part> allNecessity() {
        return partDAO.allNecessity();
    }

    @Override
    @Transactional
    public List<Part> allNotNecessity() {
        return partDAO.allNotNecessity();
    }
}
