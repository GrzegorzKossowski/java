package app.structural.facade;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.04.17.
 */
public class Facade {

    public static void main(String[] args) {

        ArmyFacade armyFacade = new ArmyFacade(new Elf(), new Orc(), new Human());
        armyFacade.attack();
        try {
            armyFacade.haveFun();
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
        }

    }

}

//-------------facade

class ArmyFacade {

    List<ArmyUnit> armyUnits = new ArrayList<>();

    public ArmyFacade(ArmyUnit ... units) {
        for(ArmyUnit u : units) {
            armyUnits.add(u);
        }
    }
    //similar methods
    public void attack() {
        for (ArmyUnit a : armyUnits) {
            a.fight();
        }
    }

    //different methods
    public void haveFun() throws NoSuchObjectException {
        for (ArmyUnit a : armyUnits) {
            if(a instanceof Human) {
                ((Human) a).sing();
            } else if (a instanceof Elf) {
                ((Elf) a).play();
            } else if (a instanceof Orc){
                ((Orc) a).dance();
            } else throw new NoSuchObjectException(new String("dsf"));
        }
    }

}

//---------------model

interface ArmyUnit {
    void fight();
}

class Elf implements ArmyUnit {

    @Override
    public void fight() {
        System.out.println("Elf is shooting a bowl...");
    }

    public void play() {
        System.out.println("Elves play such a beautiful music...");
    }

}

class Orc implements ArmyUnit {

    @Override
    public void fight() {
        System.out.println("Orc is throwing a stone...");
    }

    public void dance() {
        System.out.println("Orc is dancing awfully...");
    }
}

class Human implements ArmyUnit {

    @Override
    public void fight() {
        System.out.println("Human is fighting with sword...");
    }

    public void sing() {
        System.out.println("Humans sing funny songs...");
    }
}