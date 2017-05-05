package app.creational.builder;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 05.05.17.
 */
public class Builder {

    public static void main(String[] args) {

        Director director = new Director();
        UnitBuilder humanBuilder = new HumanUnitBuilder();
        UnitBuilder orcBuilder = new OrcUnitBuilder();

        director.setUnitBuilder(humanBuilder);
        director.constructUnit();
        Unit unit = director.getUnit();
        System.out.println(unit.toString());

        director.setUnitBuilder(orcBuilder);
        director.constructUnit();
        unit = director.getUnit();
        System.out.println(unit.toString());

    }
}

//director

class Director {

    private UnitBuilder unitBuilder;

    public void setUnitBuilder(UnitBuilder unitBuilder) {   this.unitBuilder = unitBuilder;    }

    public Unit getUnit() { return unitBuilder.getUnit();    }

    public void constructUnit() {
        unitBuilder.createNewUnit();    //!!!
        unitBuilder.setHP();
        unitBuilder.setArmor();
        unitBuilder.setWeapon();
    }

}

//builder

abstract class UnitBuilder {

    protected Unit unit;

    public Unit getUnit() {
        return unit;
    }

    public void createNewUnit() {
        this.unit = new Unit();
    }

    abstract void setHP();
    abstract void setArmor();
    abstract void setWeapon();

}

//concrete builders

class HumanUnitBuilder extends UnitBuilder {

    @Override
    void setHP() { unit.setHP(15); }

    @Override
    void setArmor() {   unit.setArmor("Steel armor");    }

    @Override
    void setWeapon() {  unit.setWeapon("Sword");    }

}

class OrcUnitBuilder extends UnitBuilder {

    @Override
    void setHP() {  unit.setHP(12);    }

    @Override
    void setArmor() {   unit.setArmor("Dragon armor");  }

    @Override
    void setWeapon() {  unit.setWeapon("Spear weapon");    }
}

//Product

class Unit {
    private int HP = 0;
    private String armor = "";
    private String weapon = "";

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "HP=" + HP +
                ", armor='" + armor + '\'' +
                ", weapon='" + weapon + '\'' +
                "}";
    }
}