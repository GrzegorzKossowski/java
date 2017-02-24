package app.creational.prototype.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class Fire extends Element {

    public Fire() {
        setType(ElementType.FIRE);
    }

    @Override
    public void scream() {
        System.out.println(">>> Trzask, trzask, aaaaaaa... parzy! Fire");
    }
}
