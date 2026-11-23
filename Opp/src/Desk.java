public class Desk {
    private String colour;
    private String material;

    public Desk(String colour, String material) {
        this.colour = colour;
        this.material = material;
    }

    public void holdBooks() {
        System.out.println("The desk is holding books.");
    }
}
