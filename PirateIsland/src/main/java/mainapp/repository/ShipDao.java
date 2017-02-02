package mainapp.repository;

import mainapp.entity.Ship;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 01.02.17.
 */
public interface ShipDao {

    Ship getShip();

    int getBeans();

    int getMoney();

    void setBeans(int beansAmount);

    void setMoney(int moneyAmount);
}
