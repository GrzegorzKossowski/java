package mainapp.controller;

import mainapp.entity.Ship;
import mainapp.service.ShipService;
import mainapp.service.TownMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 31.01.17.
 */
@Controller
public class SomeTownController {

    @Autowired
    TownMarketService townMarketService;
    @Autowired
    ShipService shipService;

    @RequestMapping(value = {"/someTown"}, method = RequestMethod.GET)
    public String someTownGet(Model model) {
        model.addAttribute("townMarket", townMarketService);
        model.addAttribute("ship", shipService);
        return "someTown";
    }

    @RequestMapping(value = {"/someTown"}, method = RequestMethod.POST)
    public String someTownPost(
            @ModelAttribute("person") Ship ship,
            Model model) {

        shipService.setMoney(ship.getMoney());
        shipService.setBeans(ship.getBeans());

        model.addAttribute("townMarket", townMarketService);
        model.addAttribute("ship", shipService);
        return "someTown";
    }


}
