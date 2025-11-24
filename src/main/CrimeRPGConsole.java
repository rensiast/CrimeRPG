import java.util.Scanner;

public class CrimeRPGConsole {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(ColorUtil.info("Welcome to Crimson Spotlight – Detective RPG"));

            System.out.print("\nEnter your detective name: ");
            String name = scanner.nextLine().trim();
            if (name.isBlank())
                name = "Detective";

            Player player = new Player(name, 3);

            boolean playing = true;
            while (playing) {
                System.out.println("\n" + "═══════════════════════════════════════");
                System.out.println(ColorUtil.info("👮 Detective " + player.getName() + " - Hearts: "
                        + player.getHearts() + " | Coins: " + player.getCoins()));
                System.out.println("═══════════════════════════════════════");

                Case selectedCase = selectCase(scanner);
                if (selectedCase == null) {
                    playing = false;
                    continue;
                }

                System.out.println("\n" + ColorUtil.info("📋 Selected Case: " + selectedCase.title));
                selectedCase.playCase(player, scanner);

                if (player.getHearts() <= 0) {
                    System.out.println("\n" + ColorUtil.error("💀 Case failed! But you can try another case."));
                    player = new Player(name, 3);
                }

                System.out.println("\n" + "Continue playing? (yes/no)");
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (continueChoice.equals("no") || continueChoice.equals("n")) {
                    playing = false;
                }
            }

            System.out.println("\n" + ColorUtil.success("Thanks for playing, Detective " + player.getName() + "!"));
        }
    }

    private static Case selectCase(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n" + ColorUtil.info("🔍 Choose Your Case:"));
                System.out.println("1. Crimson Spotlight - Easy Mode");
                System.out.println("2. Midnight Stalker - Medium Mode");
                System.out.println("3. Vanishing Act - Hard Mode");
                System.out.println("4. Exit Game");
                System.out.print("Your choice (1-4): ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        System.out.println(ColorUtil.success("Selected: Easy Mode - Crimson Spotlight"));
                        return new CrimsonSpotlightCase();
                    }
                    case 2 -> {
                        System.out.println(ColorUtil.warning("Selected: Medium Mode - Midnight Stalker"));
                        return new MidnightStalkerCase();
                    }
                    case 3 -> {
                        System.out.println(ColorUtil.error("Selected: Hard Mode - Vanishing Act"));
                        return new VanishingActCase();
                    }
                    case 4 -> {
                        return null;
                    }
                    default -> {
                        System.out.println(ColorUtil.error("Invalid choice. Please enter 1-4."));
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(ColorUtil.error("Invalid input. Please enter a number 1-4."));
            }
        }
    }
}