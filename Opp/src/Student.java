public class Student {
    private String name;
    private int age;
    private String matricNumber;

    public Student(String name, int age, String matricNumber) {
        this.name = name;
        this.age = age;
        this.matricNumber = matricNumber;
    }

    public void read() {
        System.out.println(name + " is reading.");
    }

    public void write() {
        System.out.println(name + " is writing.");
    }

    public void askQuestion() {
        System.out.println(name + " is asking a question.");
    }

    public String getName() {
        return name;
    }
}
