package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    private int savedDamage;


    public Berserk(int health, int damage, String name) {
        super(health,damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(30) + 10;
        boss.setHealth(boss.getHealth() - this.getDamage() + (savedDamage - coefficient));
        System.out.println(this.getName() + " Hits save damage " + (this.getDamage() + savedDamage - coefficient));
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }
}
