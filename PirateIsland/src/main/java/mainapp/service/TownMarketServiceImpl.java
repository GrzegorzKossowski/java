package mainapp.service;

import mainapp.entity.Product;
import mainapp.repository.TownMarketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 31.01.17.
 */
@Service
public class TownMarketServiceImpl implements TownMarketService {

    @Autowired
    private TownMarketDao townMarketDao;

    public TownMarketServiceImpl() {}

    @Override
    public String getName() {
        return townMarketDao.getName();
    }

    @Override
    public int getBeansPrice() {
        return townMarketDao.getBeansPrice();
    }

    @Override
    public void setName(String townName) {
        townMarketDao.setName(townName);
    }

    @Override
    public void setBeansPrice(int beansPrice) {
        townMarketDao.setBeansPrice(beansPrice);
    }

}
