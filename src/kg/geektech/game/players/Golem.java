package kg.geektech.game.players;

public class Golem extends Hero{
    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.TAKES_A_HIT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
