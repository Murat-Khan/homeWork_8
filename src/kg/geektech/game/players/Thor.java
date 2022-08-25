package kg.geektech.game.players;

public class Thor extends Hero{



    public Thor(int health, int damage, String name ) {
        super(health,damage, name, SuperAbility.STUN);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - this.getDamage());




    }

    public void applySuperPowerAndBlockBossAtak(Boss boss){
        boss.setHealth(boss.getHealth() - this.getDamage());
        boss.setHit(false);
        System.out.println("                             Boss is stunned");
    }

}
