package app.creational.abstractfactory;

import app.model.HumanUnit;
import app.model.OrcUnit;
import app.model.UnitType;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 12.02.17.
 */
public abstract class AbstractFactory {

    public abstract HumanUnit getHuman(UnitType unitType);

    public abstract OrcUnit getOrc(UnitType unitType);

}
