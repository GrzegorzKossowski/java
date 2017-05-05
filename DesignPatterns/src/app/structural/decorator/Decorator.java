package app.structural.decorator;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 09.04.17.
 */
public class Decorator {

    public static void main(String[] args) {

        Hit strongHit = new Kick();
        System.out.println(strongHit.power());

        strongHit = new High(strongHit);
        System.out.println(strongHit.power());

        strongHit = new Low(strongHit);
        System.out.println(strongHit.power());

    }
}

abstract class Hit {
    int hitPoints;
    public abstract int power();
}

class Kick extends Hit {
    public Kick() {
        hitPoints = 10;
    }
    @Override
    public int power() {
        return hitPoints;
    }
}

class Punch extends Hit {
    public Punch() {
        hitPoints=5;
    }
    @Override
    public int power() {
        return hitPoints;
    }
}

//--------------Decorators

abstract class HitDecorator extends Hit {
    Hit hit;
    int hitPoints;
    public abstract int power();
}

class Low extends HitDecorator {
    public Low(Hit h) {
        hit = h;
        hitPoints = 3;
    }
    @Override
    public int power() {
        return hit.power() + hitPoints;
    }
}

class High extends HitDecorator {
    public High(Hit h) {
        hit = h;
        hitPoints = 5;
    }
    @Override
    public int power() {
        return hit.power() + hitPoints;
    }
}