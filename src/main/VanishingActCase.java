import java.util.Scanner;

public class VanishingActCase extends Case {

    public VanishingActCase() {
        super("Vanishing Act [HARD MODE]", "Wealthy businessman Robert Chen disappears amid financial chaos.");
    }

    @Override
    public void playCase(Player player, Scanner scanner) {
        System.out.println("\n" + ColorUtil.info("CASE: " + title));
        System.out.println(ColorUtil.error("DIFFICULTY: HARD"));

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 1: THE EMPTY OFFICE");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nMrs. Chen: \"Robert left for work yesterday morning... never came home.\"");
        System.out.println("His car found abandoned, office computer wiped clean.");

        System.out.println("\nInitial investigation approach:");
        System.out.println("1. Forensic analysis of Robert's office");
        System.out.println("2. Deep dive into financial records");
        System.out.println("3. Interview family and staff");
        System.out.println("4. Check criminal connections");
        System.out.println(ColorUtil.warning("Type 'hint' for help (20 coins)"));

        String choice = getChoiceWithHint(player, scanner);

        int financialClues = 0;
        int personalClues = 0;
        switch (choice) {
            case "1" -> {
                System.out.println(ColorUtil.clue("Clue: Inside job or professional involvement"));
                personalClues++;
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("Major Clue: Massive financial motive"));
                financialClues += 2;
            }
            case "3" -> {
                System.out.println(ColorUtil.clue("Clue: Robert was preparing for something"));
                personalClues++;
            }
            case "4" -> {
                System.out.println(ColorUtil.error("Major Time Waste on false leads!"));
                player.loseHeart();
            }
            default -> {
                System.out.println(ColorUtil.error("Poor strategy hampers investigation!"));
                player.loseHeart();
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 2: MONEY TRAIL");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nForensic accountants uncover a complex financial web.");

        System.out.println("\nWhich theory do you pursue?");
        System.out.println("1. Investigate mountain cabin purchase");
        System.out.println("2. Trace offshore money transfers");
        System.out.println("3. Look at business partners");
        System.out.println("4. Consider wife as accomplice");

        choice = scanner.nextLine().trim();

        boolean foundSmokingGun = false;
        switch (choice) {
            case "1" -> {
                System.out.println(ColorUtil.clue("Smoking Gun: Robert planned this for months!"));
                foundSmokingGun = true;
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("Strong Evidence: Financial crime confirmed"));
                financialClues += 2;
            }
            case "3" -> {
                System.out.println(ColorUtil.error("Critical Error: Alienated potential help!"));
                player.loseHeart();
            }
            case "4" -> {
                System.out.println(ColorUtil.clue("Suspicious: Wife might be involved"));
                personalClues++;
            }
            default -> {
                System.out.println(ColorUtil.error("Critical evidence disappears due to indecision!"));
                player.loseHeart();
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 3: THE CABIN IN THE WOODS");
        System.out.println("═══════════════════════════════════════");

        boolean hasEnoughEvidence = (financialClues >= 2 && personalClues >= 1) || foundSmokingGun;

        if (hasEnoughEvidence) {
            System.out.println(ColorUtil.success("\nYou have the evidence! Robert faked his disappearance."));

            System.out.println("\nHow do you approach the cabin?");
            System.out.println("1. SWAT team raid");
            System.out.println("2. Undercover as hikers");
            System.out.println("3. Surveillance operation");
            System.out.println("4. Confront alone");

            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println(ColorUtil.success("Perfect execution! Full recovery of funds."));
                    player.addCoins(200);
                }
                case "2" -> {
                    System.out.println(ColorUtil.success("Clever strategy! Case solved with minimal risk."));
                    player.addCoins(180);
                }
                case "3" -> {
                    System.out.println(ColorUtil.warning("Patient approach... successful but close call."));
                    player.addCoins(160);
                }
                case "4" -> {
                    System.out.println(ColorUtil.error("Reckless confrontation! Seriously wounded."));
                    player.loseHeart();
                    player.loseHeart();
                    player.addCoins(120);
                }
                default -> {
                    System.out.println(ColorUtil.error("Bungled arrest! Failed immediate capture."));
                    player.loseHeart();
                    player.addCoins(80);
                }
            }
        } else {
            System.out.println(ColorUtil.error("\nInsufficient evidence... case grows cold."));
            System.out.println(ColorUtil.error("Robert successfully disappears with the money."));
            player.loseHeart();
            player.loseHeart();
            player.loseCoins(50);
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("CASE CONCLUSION");
        System.out.println("═══════════════════════════════════════");

        if (hasEnoughEvidence) {
            System.out.println(ColorUtil.success("Masterful work! Solved toughest case of your career."));
        } else {
            System.out.println(ColorUtil.warning("Hard lesson learned. Some cases can't be won."));
        }

        System.out.println(ColorUtil.info("\nHearts: " + player.getHearts() + " | Coins: " + player.getCoins()));
    }

    private String getChoiceWithHint(Player player, Scanner scanner) {
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("hint")) {
            if (player.getCoins() >= 20) {
                player.loseCoins(20);
                System.out.println(ColorUtil.clue("Hint: Follow the money and look for preparations."));
                System.out.println("Coins left: " + player.getCoins());
                System.out.println("Choose an option (1-4):");
                choice = scanner.nextLine().trim().toLowerCase();
            } else {
                System.out.println(ColorUtil.error("Not enough coins for a hint!"));
                System.out.println("Choose an option (1-4):");
                choice = scanner.nextLine().trim().toLowerCase();
            }
        }
        return choice;
    }
}