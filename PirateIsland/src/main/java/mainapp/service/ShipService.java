package mainapp.service;

import mainapp.entity.Ship;
import mainapp.repository.ShipDao;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 01.02.17.
 */
public interface ShipService {

    Ship getShip();

    int getBeans();

    int getMoney();

    void setBeans(int beansAmount);

    void setMoney(int moneyAmount);
}
