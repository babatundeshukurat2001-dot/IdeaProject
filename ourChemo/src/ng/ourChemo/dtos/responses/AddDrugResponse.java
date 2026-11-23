package ng.ourChemo.dtos.responses;

public class AddDrugResponse {
    private int id;
    private String name;
    private String brand;
    private int totalDrugAdded;
    private int totalDrugSold;
    private int batchId;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTotalDrugAdded() {
        return totalDrugAdded;
    }

    public void setTotalDrugAdded(int totalDrugAdded) {
        this.totalDrugAdded = totalDrugAdded;
    }

    public int getTotalDrugSold() {
        return totalDrugSold;
    }

    public void setTotalDrugSold(int totalDrugSold) {
        this.totalDrugSold = totalDrugSold;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "AddDrugResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", totalDrugAdded=" + totalDrugAdded +
                ", totalDrugSold=" + totalDrugSold +
                ", batchId=" + batchId +
                '}';
    }
}