public class Problem {
    private final String name;
    private final ProblemType type;
    private boolean isSolved;

    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.isSolved = false;
    }

    public String getName() {
        return name;
    }

    public ProblemType getType() {
        return type;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void solve() {
        this.isSolved = true;
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + (isSolved ? "solved" : "unsolved") + ")";
    }
}
