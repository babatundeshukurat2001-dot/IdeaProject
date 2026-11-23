public class Teacher {
    private String name;
    private String subject;
    private String staffId;

    public Teacher(String name, String subject, String staffId) {
        this.name = name;
        this.subject = subject;
        this.staffId = staffId;
    }

    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }

    public void explain() {
        System.out.println(name + " is explaining a topic.");
    }

    public void assess() {
        System.out.println(name + " is assessing students.");
    }

    public String getName() {
        return name;
    }
}
