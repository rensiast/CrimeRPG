import java.util.Scanner;

// First Case/Storyline - Easy Mode
public class CrimsonSpotlightCase extends Case {

    public CrimsonSpotlightCase() {
        super("Crimson Spotlight [EASY MODE]", "Pop star Ariya receives threatening gifts from an obsessed stalker.");
    }

    @Override
    public void playCase(Player player, Scanner scanner) {
        System.out.println("\n" + ColorUtil.info("CASE: " + title));
        System.out.println(ColorUtil.success("DIFFICULTY: EASY"));

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 1: THE FIRST THREAT");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nAriya: \"Detective, thank you for coming! I've been getting these threats...\"");
        System.out.println("She shows you a box containing a bloody rose and a note.");

        System.out.println("\nWhere do you begin your investigation?");
        System.out.println("1. Examine the threatening gifts carefully");
        System.out.println("2. Interview Ariya about her contacts");
        System.out.println("3. Check security footage");
        System.out.println(ColorUtil.warning("Type 'hint' for help (10 coins)"));

        String choice = getChoiceWithHint(player, scanner);

        switch (choice) {
            case "1" -> {
                System.out.println(ColorUtil.clue("Clue: The stalker might work with printing or packaging"));
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("Clue: Multiple suspects emerging"));
            }
            case "3" -> {
                System.out.println(ColorUtil.clue("Clue: The stalker has studied the building layout"));
            }
            default -> {
                System.out.println(ColorUtil.warning("You waste time deciding..."));
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 2: DIGGING DEEPER");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nAnother package arrives with a torn piece of Ariya's concert outfit!");

        System.out.println("\nHow do you proceed?");
        System.out.println("1. Set up surveillance at Ariya's apartment");
        System.out.println("2. Investigate Kaito, the ex-boyfriend");
        System.out.println("3. Look into the new staff member Kenji");
        System.out.println("4. Check local florists and print shops");

        choice = scanner.nextLine().trim();

        boolean foundKeyClue = false;
        switch (choice) {
            case "1", "3", "4" -> {
                System.out.println(ColorUtil.clue("Major Clue: Kenji is acting suspiciously!"));
                foundKeyClue = true;
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("Clue: Kaito might not be the stalker"));
            }
            default -> {
                System.out.println(ColorUtil.error("Poor investigation choice wastes critical time..."));
                player.loseHeart();
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 3: SHOWDOWN");
        System.out.println("═══════════════════════════════════════");

        if (foundKeyClue) {
            System.out.println(ColorUtil.success("\nYou've gathered enough evidence to confront the suspect!"));

            System.out.println("\nHow do you handle the arrest?");
            System.out.println("1. Call for backup and make a safe arrest");
            System.out.println("2. Confront him alone");
            System.out.println("3. Set a trap to catch him in the act");

            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println(ColorUtil.success("Professional approach! Case closed perfectly!"));
                    player.addCoins(100);
                }
                case "2" -> {
                    System.out.println(ColorUtil.warning("Risky move! You get a minor injury."));
                    player.loseHeart();
                    player.addCoins(75);
                }
                case "3" -> {
                    System.out.println(ColorUtil.success("Smart thinking! Solid evidence ensures conviction!"));
                    player.addCoins(90);
                }
                default -> {
                    System.out.println(ColorUtil.error("Hesitation costs you!"));
                    player.loseHeart();
                    player.addCoins(50);
                }
            }
        } else {
            System.out.println(ColorUtil.error("\nWithout enough evidence, the stalker becomes bolder!"));
            player.loseHeart();
            player.loseCoins(25);
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("CASE CONCLUSION");
        System.out.println("═══════════════════════════════════════");

        if (foundKeyClue) {
            System.out.println(ColorUtil.success("Excellent work! You solved the case professionally."));
        } else {
            System.out.println(ColorUtil.warning("Case solved, but your reputation took a hit."));
        }

        System.out.println(ColorUtil.info("\nHearts: " + player.getHearts() + " | Coins: " + player.getCoins()));
    }

    private String getChoiceWithHint(Player player, Scanner scanner) {
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("hint")) {
            if (player.getCoins() >= 10) {
                player.loseCoins(10);
                System.out.println(ColorUtil.clue("Hint: Look for patterns in timing and access."));
                System.out.println("Coins left: " + player.getCoins());
                System.out.println("Choose an option (1-3):");
                choice = scanner.nextLine().trim().toLowerCase();
            } else {
                System.out.println(ColorUtil.error("Not enough coins for a hint!"));
                System.out.println("Choose an option (1-3):");
                choice = scanner.nextLine().trim().toLowerCase();
            }
        }
        return choice;
    }
}