package app.behavioral.observer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 23.02.17.
 */
public class Hive {

    private List<Bee> bees = new ArrayList<>();
    private int honeyAmount = 0;

    public int getHoneyAmount() {
        return honeyAmount;
    }

    public void setHoneyAmount(int honeyAmount) {
        this.honeyAmount = honeyAmount;
        notifyBees();
    }

    private void notifyBees() {
        for (Bee bee : bees) {
            bee.updateHoneyAmount();
        }

    }

    public void addBee(Bee bee) {
        bees.add(bee);
    }

}
