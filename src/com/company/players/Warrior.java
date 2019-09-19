package com.company.players;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random (2)  ;
        int a = r.nextInt(4)  ;

            heroes[0].setDamage(heroes[0].getDamage() * a);
            boss.setHealth(boss.getHealth() - heroes[0].getDamage());
    }
}
