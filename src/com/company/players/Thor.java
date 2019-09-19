package com.company.players;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage, Ability ability) {
        super(health, damage, Ability.STUNNED);
    }

    public Thor(int health, int damage) {
        super(health, damage, Ability.STUNNED);
    }


    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random(1);
        int a = r.nextInt(2);

        if (a == 1) {

            boss.setDamage(0);
            System.out.println("Thor stunned the boss");
        } else {
            boss.setDamage(30);
        }
    }
}

