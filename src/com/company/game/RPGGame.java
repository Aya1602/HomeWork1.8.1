package com.company.game;

import com.company.players.*;

public class RPGGame {
    public static void startGame() {
        Boss boss = new Boss(1000, 50);
        Hero[] heroes = getHeroess();
        printStatistics(heroes, boss);
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        printStatistics(heroes, boss);
        applyAbbility(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void applyAbbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].useAbility(heroes, boss);
            }
        }
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= boss.getDamage()) {
                heroes[i].setHealth(0);
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());

            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getAbility() != Ability.HEAL && heroes[i].getAbility() != Ability.SAVE_DAMAGE_AND_REVERT) {


                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }


    }


    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won");
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
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }

    private static Hero[] getHeroess() {
        Warrior warrior = new Warrior(200, 25);
        Buffer buffer = new Buffer(200, 25);
        Tank tank = new Tank(200, 25);
        Thor thor = new Thor(200, 25);
        Golem golem = new Golem(300, 10);
        Medic medic = new Medic(100, 25);
        medic.setCurePoints();
        Hero[] heroes = {warrior, buffer, tank, thor, golem, medic};
        return heroes;
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("_______________________");
        System.out.println("Boss health " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero health  " + heroes[i].getClass().getSimpleName() + "=" + heroes[i].getHealth());

        }
        System.out.println("_______________________");
    }
}
