package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1500, 50, "Tanos");
        Warrior warrior = new Warrior(270, 10, "Aragorn");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(260, 15, "Hendelf" );
        Berserk berserk = new Berserk(280, 20, "Drax");
        Medic assistant = new Medic(290, 10, 5, "Strange");
        Thor thor = new Thor(240,25,"Thor");
        Witcher witcher = new Witcher(300,0,"Vedmak");
        Golem golem = new Golem(1000,5,"golem");
        Hero[] heroes = {thor, warrior, doc, magic, berserk, assistant, witcher,golem};
        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.hit(heroes);
        boss.chooseDefence(heroes);
        for (int i = 0; i < heroes.length; i++)
            if (boss.getDefence() != heroes[i].getAbility()) {
                if (roundNumber == 2){
                    if (heroes[i] instanceof Thor){
                        ((Thor) heroes[i]).applySuperPowerAndBlockBossAtak(boss);
                    }
                } else {
                    boss.setHit(true);
                }

                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }

        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " +
                (roundNumber == 0 ? "BEFORE FIGHT " : roundNumber)
                + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
