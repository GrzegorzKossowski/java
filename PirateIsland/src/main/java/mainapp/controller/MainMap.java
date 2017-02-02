package mainapp.controller;

import mainapp.entity.Ship;
import mainapp.entity.TownMarket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 27.01.17.
 */
@Controller
public class MainMap {

    @RequestMapping(value = {"/", "/map", "/mainMap"})
    public String mainMap() {
        return "mainMap";
    }

    @RequestMapping("/bocaDeMuerte")
    public String bocaDeMuerte() {
        return "bocaDeMuerte";
    }

    @RequestMapping("/santoFlamingo")
    public String santoFlamingo() {
        return "santoFlamingo";
    }

    @RequestMapping("/banana")
    public String banana() {
        return "banana";
    }

}
