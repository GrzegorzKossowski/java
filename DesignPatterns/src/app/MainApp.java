package app;

import app.creational.abstractfactory.AbstractFactory;
import app.creational.abstractfactory.FactoryType;
import app.creational.abstractfactory.UnitFactoryProducer;
import app.creational.factory.OrcUnitFactory;
import app.creational.prototype.ElementCache;
import app.creational.prototype.model.Air;
import app.creational.prototype.model.Element;
import app.creational.prototype.model.ElementType;
import app.creational.singleton.HumanHQSingleton;
import app.model.HumanUnit;
import app.creational.factory.HumanUnitFactory;
import app.model.OrcUnit;
import app.model.UnitType;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class MainApp {

    public static void main(String[] args) {
        //TODO:

        //Factory pattern
        System.out.println("//Factory");
        HumanUnitFactory humanUnitFactory = new HumanUnitFactory();
        HumanUnit humanUnit = humanUnitFactory.getHuman(UnitType.CAVLARY);
        humanUnit.attack();
        OrcUnitFactory orcUnitFactory = new OrcUnitFactory();
        OrcUnit orcUnit = orcUnitFactory.getOrc(UnitType.ORCPEASANT);
        orcUnit.attack();

        //Abstract Facytory
        System.out.println("\n//Abstract factory");
        AbstractFactory abstractFactory = UnitFactoryProducer.getFactory(FactoryType.HUMAN_FACTORY);
        HumanUnit humanUnit1 = abstractFactory.getHuman(UnitType.CAVLARY);
        humanUnit1.attack();
        abstractFactory = UnitFactoryProducer.getFactory(FactoryType.ORC_FACTORY);
        OrcUnit orcUnit1 = abstractFactory.getOrc(UnitType.ORCPEASANT);
        orcUnit.attack();

        //Auto ThreadSafe Singleton Pattern
        System.out.println("\n//Singleton");
        Object hqSingleton = HumanHQSingleton.getInstance();
        System.out.println(hqSingleton.hashCode());

        //Prototype pattern
        ElementCache.loadCache();
        Element element1 = ElementCache.getElement(ElementType.AIR);
        element1.scream();
        element1 = ElementCache.getElement(ElementType.FIRE);
        element1.scream();


    }
}