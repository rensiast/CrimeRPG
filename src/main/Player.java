public class Player {
    private final String name;
    private int hearts;
    private int coins = 50;

    public Player(String name, int hearts) {
        this.name = name;
        this.hearts = hearts;
    }

    public String getName() {
        return name;
    }

    public int getHearts() {
        return hearts;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public void loseHeart() {
        if (hearts > 0)
            hearts--;
    }

    public void loseCoins(int amount) {
        coins -= amount;
        if (coins < 0)
            coins = 0;
    }

    public void resetHearts(int newHearts) {
        hearts = newHearts;
    }

    public void resetCoins(int newCoins) {
        coins = newCoins;
    }
}