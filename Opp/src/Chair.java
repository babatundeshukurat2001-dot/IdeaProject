public class Chair {
    private String colour;
    private String material;

    public Chair(String colour, String material) {
        this.colour = colour;
        this.material = material;
    }

    public void provideSeating() {
        System.out.println("The chair provides seating.");
    }
}
