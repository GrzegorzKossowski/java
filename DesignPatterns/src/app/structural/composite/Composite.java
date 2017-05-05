package app.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 19.04.17.
 */
public class Composite {

    public static void main(String[] args) {
        //TODO: dokończyć?

    }
}


abstract class LegioComponent {

    // component methods
    public void add(LegioComponent legioComponent) {
        throw new UnsupportedOperationException("No such operation");
    }

    public void remove(LegioComponent legioComponent) {
        throw new UnsupportedOperationException("No such operation");
    }

    public LegioComponent getChild(int i) {
        throw new UnsupportedOperationException("No such operation");
    }

    public String showStructure() {
        throw new UnsupportedOperationException("No such operation");
    }

    // node or leaf methods
    public void attack() {
        throw new UnsupportedOperationException("No such operation");
    }

    public String getName() {
        throw new UnsupportedOperationException("No such operation");
    }

}

class Bellator extends LegioComponent {

    String name;

    public Bellator(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String showStructure() {
        return ".";
    }

    @Override
    public void attack() {
        System.out.println("Ego impetum!!!");
    }
}

// CENTURIAE

class Centuriae extends LegioComponent {

    List<LegioComponent> list = new ArrayList<>();
    String name;

    public Centuriae(String name) {
        this.name = name;
    }

    @Override
    public void add(LegioComponent legioComponent) {
        list.add(legioComponent);
    }

    @Override
    public String showStructure() {
        StringBuilder sb = new StringBuilder();
        for(LegioComponent l : list) {
            sb.append(l.showStructure() + " ");
        }
        return sb.toString();
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
