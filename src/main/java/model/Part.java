package model;

public class Part {
    private int id;
    private String name;
    private boolean necessity;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNecessity() {
        return necessity;
    }

    public void setNecessity(boolean necessity) {
        this.necessity = necessity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
