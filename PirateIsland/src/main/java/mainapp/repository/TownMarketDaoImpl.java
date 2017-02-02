package mainapp.repository;

import mainapp.entity.Product;
import mainapp.entity.TownMarket;
import org.springframework.stereotype.Repository;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 31.01.17.
 */
@Repository
public class TownMarketDaoImpl implements TownMarketDao {

    private static TownMarket townMarket;

    static {
        townMarket = new TownMarket("Some Town", (int) (Math.random()*10) + 5);
    }

    public TownMarketDaoImpl() {}

    @Override
    public String getName() {
        return townMarket.getName();
    };

    @Override
    public int getBeansPrice() {
        return townMarket.getBeansPrice();
    }

    @Override
    public void setName(String townName) {
        townMarket.setName(townName);
    }

    @Override
    public void setBeansPrice(int beansPrice) {
        townMarket.setBeansPrice(beansPrice);
    }

}
