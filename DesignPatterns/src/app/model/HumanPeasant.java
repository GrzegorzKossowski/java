package app.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class HumanPeasant implements HumanUnit {
    @Override
    public void attack() {
        System.out.println("HumanPeasant doesn't attack at all....");
    }
}
