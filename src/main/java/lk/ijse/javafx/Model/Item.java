package lk.ijse.javafx.Model;

public class Item {
    private int id;
    private String description;
    private int qty;
    private double price;
    private int supId;

    public Item(int id, String description, int qty, double price, int supId) {
        this.id=id;
        this.description=description;
        this.qty=qty;
        this.price=price;
        this.supId=supId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", price=" + price + '\'' +
                ", supId='" + supId +
                '}';
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }
}
