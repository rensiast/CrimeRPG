public class ColorUtil {
    // Reset
    public static final String RESET = "\033[0m";

    // Color palette
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String CYAN = "\033[0;36m";

    // Methods for assigning colors
    public static String success(String text) {
        return GREEN + text + RESET;
    }

    public static String warning(String text) {
        return YELLOW + text + RESET;
    }

    public static String error(String text) {
        return RED + text + RESET;
    }

    public static String info(String text) {
        return CYAN + text + RESET;
    }

    public static String clue(String text) {
        return BLUE + text + RESET;
    }
}