import java.util.Scanner;

public class MidnightStalkerCase extends Case {

    public MidnightStalkerCase() {
        super("Midnight Stalker [MEDIUM MODE]",
                "A serial stalker terrorizes college students, leaving cryptic messages.");
    }

    @Override
    public void playCase(Player player, Scanner scanner) {
        System.out.println("\n" + ColorUtil.info("CASE: " + title));
        System.out.println(ColorUtil.warning("DIFFICULTY: MEDIUM"));

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 1: THE FIRST VICTIM");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nCampus Security: \"Three students in two weeks! All followed after night classes.\"");
        System.out.println("All reports mention a tall figure in dark clothing, moving silently.");

        System.out.println("\nWhere do you start your investigation?");
        System.out.println("1. Interview the victims for details");
        System.out.println("2. Check campus security camera footage");
        System.out.println("3. Examine the threatening drawings");
        System.out.println("4. Patrol campus during night hours");
        System.out.println(ColorUtil.warning("Type 'hint' for help (15 coins)"));

        String choice = getChoiceWithHint(player, scanner);

        int cluesFound = 0;
        switch (choice) {
            case "1" -> {
                System.out.println(ColorUtil.clue("🔍 Clue: Stalker knows campus well, possibly works here"));
                cluesFound++;
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("🔍 Clue: Stalker has insider knowledge of camera locations"));
                cluesFound++;
            }
            case "3" -> {
                System.out.println(
                        ColorUtil.clue("🔍 Major Clue: Stalker has artistic skill and access to art supplies"));
                cluesFound += 2;
            }
            case "4" -> {
                System.out.println(ColorUtil.clue("🔍 Clue: Stalker might be female, uses maintenance access"));
                cluesFound++;
            }
            default -> {
                System.out.println(ColorUtil.error("Poor choice wastes valuable time..."));
                System.out.println(ColorUtil.error("Another student gets stalked while you're ineffective!"));
                player.loseHeart();
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 2: THE ART DEPARTMENT CONNECTION");
        System.out.println("═══════════════════════════════════════");

        System.out.println("\nAnother student reports being followed from the art building.");
        System.out.println("The stalker left a detailed map of the victim's schedule.");

        System.out.println("\nYour investigation leads to three suspects:");
        System.out.println("1. Mr. Henderson - Night janitor");
        System.out.println("2. Lisa Chen - Art student");
        System.out.println("3. Dr. Roberts - Psychology professor");

        System.out.println("\nWho do you investigate first?");
        System.out.println("1. Check Henderson's work schedule");
        System.out.println("2. Review Lisa's art portfolio");
        System.out.println("3. Examine Dr. Roberts' research");
        System.out.println("4. Set up surveillance on all three");

        choice = scanner.nextLine().trim();

        boolean identifiedStalker = false;
        switch (choice) {
            case "1" -> {
                System.out.println(ColorUtil.clue("🔍 Strong Evidence: Henderson is your prime suspect!"));
                identifiedStalker = true;
            }
            case "2" -> {
                System.out.println(ColorUtil.clue("🔍 Suspicious: Lisa has means and motive"));
                cluesFound++;
            }
            case "3" -> {
                System.out.println(ColorUtil.clue("🔍 Unlikely: Professor has solid alibis"));
            }
            case "4" -> {
                System.out.println(ColorUtil.error("❌ Critical Mistake: You alerted the real stalker!"));
                player.loseHeart();
            }
            default -> {
                System.out.println(ColorUtil.error("The stalker attacks another student while you hesitate!"));
                player.loseHeart();
            }
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("ACT 3: MIDNIGHT SHOWDOWN");
        System.out.println("═══════════════════════════════════════");

        if (identifiedStalker && cluesFound >= 2) {
            System.out.println(ColorUtil.success("\nYou have enough evidence! Henderson is the Midnight Stalker."));

            System.out.println("\nHow do you apprehend him?");
            System.out.println("1. Coordinate with campus police");
            System.out.println("2. Confront him alone in tunnels");
            System.out.println("3. Set a trap with plainclothes officer");

            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println(ColorUtil.success("✅ Professional takedown!"));
                    player.addCoins(120);
                }
                case "2" -> {
                    System.out.println(ColorUtil.warning("⚠️ Dangerous confrontation! You take injuries."));
                    player.loseHeart();
                    player.addCoins(100);
                }
                case "3" -> {
                    System.out.println(ColorUtil.success("🎯 Brilliant strategy! Solid evidence ensures sentencing."));
                    player.addCoins(140);
                }
                default -> {
                    System.out.println(ColorUtil.error("❌ Poor execution! Henderson escapes and injures a student."));
                    player.loseHeart();
                    player.addCoins(80);
                }
            }
        } else {
            System.out.println(ColorUtil.error("\nWithout solid evidence, the stalking continues..."));
            System.out.println(ColorUtil.error("Another student is seriously traumatized."));
            player.loseHeart();
            player.loseCoins(30);
        }

        System.out.println("\n" + "═══════════════════════════════════════");
        System.out.println("CASE CONCLUSION");
        System.out.println("═══════════════════════════════════════");

        if (identifiedStalker) {
            System.out.println(ColorUtil.success("🎉 Excellent detective work! You stopped a dangerous predator."));
        } else {
            System.out.println(ColorUtil.warning("⚠️ Partial success. The stalker is gone for now, but not caught."));
        }

        System.out.println(ColorUtil.info("\nHearts: " + player.getHearts() + " | Coins: " + player.getCoins()));
    }

    private String getChoiceWithHint(Player player, Scanner scanner) {
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("hint")) {
            if (player.getCoins() >= 15) {
                player.loseCoins(15);
                System.out
                        .println(ColorUtil.clue("💡 Hint: Look for someone with campus access and artistic ability."));
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