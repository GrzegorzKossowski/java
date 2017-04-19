package app.behavioral.template;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 18.04.17.
 * In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses
 * can override the method implementation as per need but the invocation is to be in the same way as defined
 * by an abstract class.
 */
public class Template {

    public static void main(String[] args) {

        Unit unit1 = new Human();
        Unit unit2 = new Elf();
        Unit unit3 = new Orc();

        unit1.runBattle();
        unit2.runBattle();
        unit3.runBattle();

    }
}


abstract class Unit {

    final void runBattle() {
        takePositions();
        attack();
        hook();
        retreat();
    }

    abstract void attack();

    public void takePositions() {
        System.out.println("Take your positions, units!!!");
    }

    public void retreat() {
        System.out.println("Go back!!! Go back!!!\n");
    }

    public void hook() {}

}

class Human extends Unit {

    @Override
    void attack() {
        System.out.println("Attack with swords!!!");
    }
}

class Elf extends Unit {

    @Override
    void attack() {
        System.out.println("Attack with bows!!!");
    }
}

class Orc extends Unit {

    @Override
    void attack() {
        System.out.println("Attack with stones!!!");
    }

    @Override
    public void hook() {
        System.out.println("Orc hooked some body meat from enemies...");
    }
}
