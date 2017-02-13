package app.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class HumanCavlary implements HumanUnit {
    @Override
    public void attack() {
        System.out.println("HumanCavlary attacks with lance.... Pa-ta-tay");
    }
}
