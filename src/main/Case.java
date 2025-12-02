public abstract class Case {
    // Abstraction
    protected String title;
    protected String description;

    public Case(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Abstract Method
    public abstract void playCase(Player player, java.util.Scanner scanner);
}
