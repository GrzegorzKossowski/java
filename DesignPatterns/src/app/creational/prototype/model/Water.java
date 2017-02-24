package app.creational.prototype.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class Water extends Element {

    public Water() {
        setType(ElementType.WATER);
    }

    @Override
    public void scream() {
        System.out.println(">>> Chhhhhlllluuuuppppp.... water");
    }

}
