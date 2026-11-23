public class Marker {
    private String colour;
    private String brand;

    public Marker(String colour, String brand) {
        this.colour = colour;
        this.brand = brand;
    }

    public void write() {
        System.out.println("The " + colour + " marker is writing.");
    }
}
