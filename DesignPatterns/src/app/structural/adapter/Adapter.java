package app.structural.adapter;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.04.17.
 */
public class Adapter {

    public static void main(String[] args) {
        ElfUnit elfUnit = new Elf();
        OrcUnit orcUnit = new Orc();

        OrcToElfAdapter orcAdapter = new OrcToElfAdapter(orcUnit);
        orcAdapter.fight();
        orcAdapter.sing();


    }
}

interface OrcUnit {
    void fight();
    void stink();
}

interface ElfUnit {
    void fight();
    void sing();
}

//---------- adapter

class OrcToElfAdapter implements ElfUnit {

    OrcUnit orc;

    public OrcToElfAdapter(OrcUnit orc) {
        this.orc = orc;
    }

    @Override
    public void fight() {
        this.orc.fight();
    }

    @Override
    public void sing() {
        System.out.print("When Orc sings, ");
        orc.stink();
    }
}

//---------- model

class Orc implements OrcUnit {

    @Override
    public void fight() {
        System.out.println("Orc is fighting with mace");
    }

    @Override
    public void stink() {
        System.out.println("Orc is stinking all the time");
    }
}

class Elf implements ElfUnit {

    @Override
    public void fight() {
        System.out.println("Elf fights with bow...");
    }

    @Override
    public void sing() {
        System.out.println("Elf is singing songs of Elenor...");
    }
}