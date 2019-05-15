package test.dao;

import test.model.Part;

import java.util.List;

public interface PartDAO {
    List<Part> PartsList (int page, String sorted);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getId(int id);
    int partsCount();
    List<Part> search(String query);
    List<Part> allNecessity();
    List<Part> allNotNecessity();
}
