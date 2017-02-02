package mainapp.entity;

import java.io.Serializable;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 29.01.17.
 */
public class TownMarket implements Serializable {

    private String name;
    private int beansPrice;

    public TownMarket() {}

    public TownMarket(String name, int beansPrice) {
        this.name = name;
        this.beansPrice = beansPrice;
    }

    public TownMarket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeansPrice() {
        return beansPrice;
    }

    public void setBeansPrice(int beansPrice) {
        this.beansPrice = beansPrice;
    }
}
