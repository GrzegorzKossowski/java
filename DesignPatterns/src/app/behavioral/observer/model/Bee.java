package app.behavioral.observer.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 23.02.17.
 */
public abstract class Bee {

    protected Hive hive;

    public abstract void updateHoneyAmount();
    public abstract void getHoneyInHive();

}
