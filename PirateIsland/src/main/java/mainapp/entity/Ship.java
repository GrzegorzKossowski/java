package mainapp.entity;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 29.01.17.
 */
public class Ship {

    private int money;
    private int beans;

    public Ship() {
        this.money = (int) (Math.random()*500) + 1000;
        this.beans = 0;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "money=" + money +
                ", beans=" + beans +
                '}';
    }

}
