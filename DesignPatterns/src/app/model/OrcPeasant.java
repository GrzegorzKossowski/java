package app.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 12.02.17.
 */
public class OrcPeasant implements OrcUnit {
    @Override
    public void attack() {
        System.out.println("Orc peasant fight with it's fists...");
    }
}
