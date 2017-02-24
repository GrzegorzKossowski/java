package app.behavioral.observer.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 23.02.17.
 */
public class Worker extends Bee {

    private int honeyInHive = 0;

    public Worker(Hive hive) {
        this.hive = hive;
        this.hive.addBee(this);
        this.honeyInHive = hive.getHoneyAmount();
    }

    @Override
    public void updateHoneyAmount() {
        this.honeyInHive = hive.getHoneyAmount();
    }

    @Override
    public void getHoneyInHive() {
            System.out.println("Honey in Hive is: " + this.honeyInHive);
    }

}
