package app.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.02.17.
 */
public class HumanKnight implements HumanUnit {
    @Override
    public void attack() {
        System.out.println("HumanKnight attack with sword.... Agrrrrrr...");
    }
}
