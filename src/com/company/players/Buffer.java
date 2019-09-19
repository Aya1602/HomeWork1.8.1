package com.company.players;

import java.util.Random;

public class Buffer extends Hero {
    public Buffer(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    public int getIncreasedDamage() {
        return increasedDamage;
    }

    public void setIncreasedDamage() {
        this.increasedDamage = new Random().nextInt(30) + 5;
    }

    private int increasedDamage ;
    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i <4 ; i++) {
            if (heroes[i].getDamage()>0 ) {
                setIncreasedDamage();
                heroes[i].setDamage(heroes[i].getDamage() + getIncreasedDamage());
                System.out.println("Buffer increased   " + heroes[i].getClass().getSimpleName() + " " + getIncreasedDamage());
            }
        }

    }
}
