package task;

public class BattleUnit {
    private int strength;
    private int armor;
    private int health;
    private int x;
    private int y;

    public BattleUnit(int strength, int armor, int health, int x, int y) {
        this.strength = strength;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getArmor() {
        return this.armor;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHealth() {
        return this.health;
    }

    public void attacked(BattleUnit enemy) {
        if (this.armor >= 0 && enemy.getStrength() > this.armor) {
            this.health -= enemy.getStrength() - this.armor;
        } else if (this.armor < 0) {
            this.health -= enemy.getStrength();
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void moveUp() {
        --this.y;
    }

    public void moveDown() {
        ++this.y;
    }

    public void moveLeft() {
        --this.x;
    }

    public void moveRight() {
        ++this.x;
    }
}
