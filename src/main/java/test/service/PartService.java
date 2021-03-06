package test.service;

import test.model.Part;

import java.util.List;

public interface PartService {
    List<Part> PartsList (int page, String sorted);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getId(int id);
    int partsCount();
    List<Part> search(String query);
    int countPC ();
    List<Part> allNecessity();
    List<Part> allNotNecessity();

}
