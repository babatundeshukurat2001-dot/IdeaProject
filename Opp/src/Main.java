public class Main {
    public static void main(String[] args) {


        Student student = new Student("Shukurat", 25, "20180206037");

        Teacher teacher = new Teacher("Mr Chibuzo", "Java", "Chi2090");

        Desk desk = new Desk("Brown", "Wood");

        Chair chair = new Chair("Black", "Plastic");

        Whiteboard board = new Whiteboard("White", 10.5);

        Marker marker = new Marker("Blue", "Bic");

        student.read();
        student.write();
        student.askQuestion();

        teacher.teach();
        teacher.explain();
        teacher.assess();

        desk.holdBooks();
        chair.provideSeating();
        board.displayInformation();
        marker.write();
    }
}
