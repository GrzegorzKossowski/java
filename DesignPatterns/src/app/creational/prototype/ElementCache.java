package app.creational.prototype;

import app.creational.prototype.model.*;

import java.util.Hashtable;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class ElementCache {

    private static Hashtable<ElementType, Element> elementMap = new Hashtable<>();

    public static Element getElement(ElementType elementType) {

        Element element = elementMap.get(elementType);
        return (Element) element.clone();

    }

    public static void loadCache() {

        Air air = new Air();
        elementMap.put(air.getType(), air);

        Earth earth = new Earth();
        elementMap.put(earth.getType(), earth);

        Fire fire = new Fire();
        elementMap.put(fire.getType(), fire);

        Water water = new Water();
        elementMap.put(water.getType(), water);

    }


}
