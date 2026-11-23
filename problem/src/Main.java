import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ola");

        person.addProblem(new Problem("Food is expensive", ProblemType.FINANCIAL));
        person.addProblem(new Problem("Struggling to pray daily", ProblemType.SPIRITUAL));
        person.addProblem(new Problem("Semicolon assignment", ProblemType.EDUCATION));
        person.addProblem(new Problem("Low shop sales", ProblemType.BUSINESS));
        person.addProblem(new Problem("Laptop won't boot", ProblemType.TECHNICAL));

        System.out.println(person.getName() + "'s unsolved problems:");
        print(person.recountUnsolvedProblems());

        person.solveProblem("Laptop won't boot");
        person.solveProblem("Food is expensive");

        System.out.println("\nAfter solving two problems:");
        print(person.recountUnsolvedProblems());
    }

    private static void print(List<Problem> problems) {
        for (Problem problem : problems) {
            System.out.println(" - " + problem);
        }
    }
}