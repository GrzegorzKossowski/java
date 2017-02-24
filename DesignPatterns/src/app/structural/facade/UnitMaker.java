package app.structural.facade;

import app.model.*;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public class UnitMaker {

    private Unit humanCavlary;
    private Unit humanKnight;
    private Unit humanPeasant;
    private Unit orcCavlary;
    private Unit orcKnight;
    private Unit orcPeasant;

    public UnitMaker() {
        humanCavlary = new HumanCavlary();
        humanKnight = new HumanKnight();
        humanPeasant = new HumanPeasant();
        orcCavlary = new OrcCavlary();
        orcKnight = new OrcKnight();
        orcPeasant = new OrcPeasant();
    }

    public void attackHumanCavlary() {
        humanCavlary.attack();
    }

    public void attackHumanKnight(){
        humanKnight.attack();
    }

    public void attackHumanPeasant() {
        humanPeasant.attack();
    }

    public void attackOrcCavlary() {
        orcCavlary.attack();
    }

    public void attackOrcKnight() {
        orcKnight.attack();
    }

    public void attackOrcPeasant() {
        orcPeasant.attack();
    }

}
