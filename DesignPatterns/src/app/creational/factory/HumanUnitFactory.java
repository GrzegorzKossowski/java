package app.creational.factory;

import app.creational.abstractfactory.AbstractFactory;
import app.model.*;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class HumanUnitFactory extends AbstractFactory {

    public HumanUnit getHuman(UnitType unitType) {

        if(unitType == null) {
            return null;
        }
        switch (unitType) {
            case CAVLARY:
                return new HumanCavlary();
            case KNIGHT:
                return new HumanKnight();
            case PEASANT:
                return new HumanPeasant();
            default:
                return null;
        }
    }

    @Override
    public OrcUnit getOrc(UnitType unitType) {
        return null;
    }
}
