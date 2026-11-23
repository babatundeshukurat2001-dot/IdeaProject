package ng.ourChemo.data.models;

import java.util.List;

public class Drug {
    private int sellingPrice;
    private String name;
    private int id;
    private String brand;
    private int quantity;
    private List<Batch> bathes;
    private Batch batch;

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public List<Batch> getBathes() {
        return bathes;
    }

    public void setBathes(List<Batch> bathes) {
        this.bathes.add(batch);
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}