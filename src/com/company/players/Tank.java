package com.company.players;
public class Tank extends Hero {
    public Tank(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);

    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {

            heroes[2].setDamage(heroes[2].getDamage() + boss.getDamage());
            boss.setHealth(boss.getHealth() - heroes[2].getDamage());
        System.out.println("Tank used critical hit");
    }
}
