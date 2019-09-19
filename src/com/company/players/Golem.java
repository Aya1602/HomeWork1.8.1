package com.company.players;

import java.util.Random;

public class Golem extends Hero {
    public Golem(int health, int damage, Ability ability) {
        super(health, damage, ability);
    }

    public Golem(int health, int damage) {
        super(health, damage, Ability.ACCEPT_DAMAGE_TO_OTHER_PLAYERS);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random (1);
        int percent = r.nextInt(100) ;
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getAbility() != Ability.ACCEPT_DAMAGE_TO_OTHER_PLAYERS) {
                this.setHealth(heroes[i].getHealth() - boss.getDamage() *percent / 100);
                System.out.println("Golem accept " + heroes[i].getClass().getSimpleName() + "  "+ this.getHealth() + " damage to other heroes  ");
            }
        }

    }
}
