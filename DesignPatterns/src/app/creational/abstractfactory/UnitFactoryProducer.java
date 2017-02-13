package app.creational.abstractfactory;

import app.creational.factory.HumanUnitFactory;
import app.creational.factory.OrcUnitFactory;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 12.02.17.
 */
public class UnitFactoryProducer {

    public static AbstractFactory getFactory(FactoryType factoryType) {

        switch (factoryType) {
            case ORC_FACTORY:
                return new OrcUnitFactory();
            case HUMAN_FACTORY:
                return new HumanUnitFactory();
                default:
                    return null;
        }
    }

}
