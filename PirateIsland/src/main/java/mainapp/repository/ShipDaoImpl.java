package mainapp.repository;

import mainapp.entity.Ship;
import org.springframework.stereotype.Repository;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 31.01.17.
 */
@Repository
public class ShipDaoImpl implements ShipDao {

    private static Ship ship;

    static {
        ship = new Ship();
    }

    public ShipDaoImpl() {}

    @Override
    public Ship getShip() {
        return ship;
    }

    @Override
    public int getBeans() {
        return ship.getBeans();
    }

    @Override
    public int getMoney() {
        return ship.getMoney();
    }

    @Override
    public void setBeans(int beansAmount) {
        ship.setBeans(beansAmount);
    }

    @Override
    public void setMoney(int moneyAmount) {
        ship.setMoney(moneyAmount);
    }


}
