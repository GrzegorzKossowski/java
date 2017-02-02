package mainapp.service;

import mainapp.entity.Ship;
import mainapp.repository.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 01.02.17.
 */
@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipDao shipDao;

    public ShipServiceImpl() {}

    @Override
    public Ship getShip() {
        return shipDao.getShip();
    }

    @Override
    public int getBeans() {
        return shipDao.getBeans();
    }

    @Override
    public int getMoney() {
        return shipDao.getMoney();
    }

    @Override
    public void setBeans(int beansAmount) {
        shipDao.setBeans(beansAmount);
    }

    @Override
    public void setMoney(int moneyAmount) {
        shipDao.setMoney(moneyAmount);
    }

}
