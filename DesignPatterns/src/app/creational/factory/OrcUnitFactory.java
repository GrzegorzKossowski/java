package app.creational.factory;

import app.creational.abstractfactory.AbstractFactory;
import app.model.*;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class OrcUnitFactory extends AbstractFactory{


    public OrcUnit getOrc(UnitType unitType) {

        if(unitType == null) {
            return null;
        }
        switch (unitType) {
            case ORCCAVLARY:
                return new OrcCavlary();
            case ORCKNIGHT:
                return new OrcKnight();
            case ORCPEASANT:
                return new OrcPeasant();
            default:
                return null;
        }
    }

    @Override
    public HumanUnit getHuman(UnitType unitType) {
        return null;
    }

}
