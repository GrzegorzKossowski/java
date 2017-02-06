package mainapp.service;

import mainapp.repository.AdventureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 02.02.17.
 */
@Service
public class AdventureServiceImpl implements AdventureService {

    @Autowired
    private AdventureDao adventureDao;

    @Override
    public String getAdventure() {
        return adventureDao.getAdventure();
    }

}