package mainapp.repository;

import mainapp.entity.Adventure;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 02.02.17.
 */
@Repository
public class AdventureDaoImpl implements AdventureDao {

    private static Map<Integer, Adventure> adventures;

    static {
        adventures = new HashMap<Integer, Adventure>() {
            {
                put(1, new Adventure("cargo"));
                put(2, new Adventure("cargo"));
                put(3, new Adventure("cargo"));
                put(4, new Adventure("cargo"));
                put(5, new Adventure("pirates"));
                put(6, new Adventure("pirates"));
                put(7, new Adventure("pirates"));
                put(8, new Adventure("pirates"));
                put(9, new Adventure("pirates"));
                put(10, new Adventure("pirates"));
            }
        };
    }

    @Override
    public String getAdventure() {
        int rand = (int) (Math.random()*10)+1;
        System.out.println(rand);
        return adventures.get(rand).getName();
    }

}
