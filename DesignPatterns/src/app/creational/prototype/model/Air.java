package app.creational.prototype.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class Air extends Element {

    public Air() {
        setType(ElementType.AIR);
    }

    @Override
    public void scream() {
        System.out.println("\n>>> Wiuuuuuuuuuuu, szzzzz.... Air");
    }
}
