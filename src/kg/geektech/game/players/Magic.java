package kg.geektech.game.players;

public class Magic extends Hero {
    private int increaseDamage = 1;

    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {

            if (this != heroes[i] && !(heroes[i] instanceof Witcher)) {
                heroes[i].setDamage(heroes[i].getDamage() + this.increaseDamage);
            }
        }
        System.out.println(this.getName() + "                 use boost Damage ");

    }

    public int getIncreaseDamage() {
        return increaseDamage;
    }
}
