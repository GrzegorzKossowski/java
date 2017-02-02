package mainapp.service;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 02.02.17.
 */
public interface TownMarketService {
    String getName();

    int getBeansPrice();

    void setName(String townName);

    void setBeansPrice(int beansPrice);
}
