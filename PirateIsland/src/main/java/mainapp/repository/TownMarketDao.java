package mainapp.repository;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 02.02.17.
 */
public interface TownMarketDao {
    String getName();

    int getBeansPrice();

    void setName(String townName);

    void setBeansPrice(int beansPrice);
}
