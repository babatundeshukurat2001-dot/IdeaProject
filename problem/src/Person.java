import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Problem> problems = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public boolean solveProblem(String problemName) {
        for (Problem problem : problems) {
            if (problem.getName().equalsIgnoreCase(problemName) && !problem.isSolved()) {
                problem.solve();
                return true;
            }
        }
        return false;
    }

    public List<Problem> recountUnsolvedProblems() {
        List<Problem> unsolved = new ArrayList<>();
        for (Problem problem : problems) {
            if (!problem.isSolved()) {
                unsolved.add(problem);
            }
        }
        return unsolved;
    }

    public List<Problem> getProblems() {
        return new ArrayList<>(problems);
    }
}