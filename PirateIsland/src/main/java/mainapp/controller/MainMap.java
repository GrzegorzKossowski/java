package mainapp.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import mainapp.entity.Ship;
import mainapp.entity.TownMarket;
import mainapp.service.AdventureService;
import mainapp.service.ShipService;
import mainapp.service.TownMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 27.01.17.
 */
@Controller
public class MainMap {

    @Autowired
    TownMarketService townMarketService;
    @Autowired
    ShipService shipService;
    @Autowired
    AdventureService adventureService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "mainMap";
    }

    @RequestMapping(value = {"/{someLink}"}, method = RequestMethod.GET)
    public String someTownGet(@PathVariable("someLink") String link,
                              Model model) {

            if(link.equals("adventure")) {
                String newAdventure = adventureService.getAdventure();
                    model.addAttribute("adv", newAdventure);
                    model.addAttribute("link", "/mainMap");
                    return newAdventure;
            }

        model.addAttribute("townMarket", townMarketService);
        model.addAttribute("ship", shipService);
        return link;
    }

    @RequestMapping(value = {"/{someLink}"}, method = RequestMethod.POST)
    public String someTownPost(@PathVariable("someLink") String link,
            @ModelAttribute("person") Ship ship,
            Model model) {

        shipService.setMoney(ship.getMoney());
        shipService.setBeans(ship.getBeans());

        model.addAttribute("townMarket", townMarketService);
        model.addAttribute("ship", shipService);
        return link;
    }

}
