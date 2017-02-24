package app.creational.prototype.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class Earth extends Element {

    public Earth() {
        setType(ElementType.EARTH);
    }

    @Override
    public void scream() {
        System.out.println(">>> Szzzzz.... Grrrrrr... Duuuu duuuu Earth");
    }
}
