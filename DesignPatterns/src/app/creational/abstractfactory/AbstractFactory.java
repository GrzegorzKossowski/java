package app.creational.abstractfactory;

import app.creational.UnitType;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 10.04.17.
 */
public class AbstractFactory {

    public static void main(String[] args) {
        //TODO:
        UnitFactory unitFactory = new OrcUnitFactory();
        Unit unit = unitFactory.createUnit(UnitType.ORC);
        unit.fight();

        unitFactory = new HumanUnitFactory();
        unit = unitFactory.createUnit(UnitType.KNIGHT);
        unit.fight();

    }
}

abstract class UnitFactory {

    public abstract Unit createUnit(UnitType unitType);

}

class OrcUnitFactory extends UnitFactory {
    @Override
    public Unit createUnit(UnitType orcUnitType) {
        switch (orcUnitType) {
            case ORC:
                return new Orc();
            case TROLL:
                return new Troll();
            case GNOME:
                return new Gnome();
            default:
                return null;
        }
    }
}

class HumanUnitFactory extends UnitFactory {
    @Override
    public Unit createUnit(UnitType humanUnitType) {
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

interface Unit {
    void fight();
}

class Cavlary implements Unit {
    @Override
    public void fight() {
        System.out.println("I am Cavlary, I fight with lance!");
    }
}

class Knight implements Unit {
    @Override
    public void fight() {
        System.out.println("I am Knight, I fight with sword!");
    }
}

class Peasant implements Unit {
    @Override
    public void fight() {
        System.out.println("I am peasant, I fight with flail!");
    }
}

class Orc implements Unit {
    @Override
    public void fight() {
        System.out.println("I am Orc, I fight with stick!");
    }
}

class Troll implements Unit {
    @Override
    public void fight() {
        System.out.println("I am Orc, I fight with spear!");
    }
}

class Gnome implements Unit {
    @Override
    public void fight() {
        System.out.println("I am Orc, I fight with slingshot!");
    }
}