package app.creational.factory;

import app.creational.UnitType;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 10.04.17.
 */
public class Factory {

    public static void main(String[] args) {

        SimpleUnitFactory unitFactory = new SimpleUnitFactory();
        HumanUnit humanUnit = unitFactory.createHumanUnit(UnitType.CAVLARY);
        humanUnit.fight();
        humanUnit = unitFactory.createHumanUnit(UnitType.KNIGHT);
        humanUnit.fight();
        humanUnit = unitFactory.createHumanUnit(UnitType.PEASANT);
        humanUnit.fight();

    }
}

class SimpleUnitFactory {

    public HumanUnit createHumanUnit(UnitType humanUnitType) {

        switch (humanUnitType) {
            case CAVLARY:
                return new Cavlary();
            case KNIGHT:
                return new Knight();
            case PEASANT:
                return new Peasant();
            default:
                return null;
        }
    }
}

interface HumanUnit {
    void fight();
}

class Cavlary implements HumanUnit {
    @Override
    public void fight() {
        System.out.println("I am Cavlary, I fight with lance!");
    }
}

class Knight implements HumanUnit {
    @Override
    public void fight() {
        System.out.println("I am Knight, I fight with sword!");
    }
}

class Peasant implements HumanUnit {
    @Override
    public void fight() {
        System.out.println("I am peasant, I fight with flail!");
    }
}

