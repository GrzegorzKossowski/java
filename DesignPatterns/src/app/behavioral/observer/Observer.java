package app.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 09.04.17.
 */
public class Observer {

    public static void main(String[] args) {

        Hive hive = new Hive();
        Observers queen = new Queen(hive);
        hive.registerObserver(queen);
        hive.setHoneyAmount(15);
        hive.removeObserver(queen);
        hive.setHoneyAmount(10);
        for(int i=0; i<5; i++) {
            hive.registerObserver(new Worker(hive));
        }
        queen.registerMe(hive);
        hive.setHoneyAmount(100);
        queen.unregisterMe(hive);
        hive.setHoneyAmount(50);

    }

}

//--------------Subject

interface Subject {
    void registerObserver(Observers o);
    void removeObserver(Observers o);
    void removeObserverById(int id);
    void notifyObservers();
}

class Hive implements Subject {

    int honeyAmount;
    List<Observers> observersList;

    public Hive() {
        observersList = new ArrayList<>();
    }

    public int getHoneyAmount() {
        return honeyAmount;
    }

    public void setHoneyAmount(int honeyAmount) {
        this.honeyAmount = honeyAmount;
        honeyChanged();
    }

    public void honeyChanged() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observers o) {
        observersList.add(o);
    }

    @Override
    public void removeObserver(Observers o) {
        int i = observersList.indexOf(o);
        if(i >= 0) {
            observersList.remove(i);
        }
    }

    @Override
    public void removeObserverById(int id) {
        if(id >= 0 && id < observersList.size()) {
            observersList.remove(id);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observers o : observersList) {
            o.update(getHoneyAmount());
        }
    }

}

//-------------Observers

interface Observers {
    void update(int honeyAmount);
    void registerMe(Subject subject);
    void unregisterMe(Subject subject);
}

abstract class Bee implements Observers {
    Subject subject;

    @Override
    public void registerMe(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void unregisterMe(Subject subject) {
        subject.removeObserver(this);
    }
}

class Queen extends Bee {

    public Queen(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update(int honeyAmount) {
        System.out.println("I am THE QUEEN. My honey is..." + honeyAmount);
    }

}

class Worker extends Bee {

    public Worker(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update(int honeyAmount) {
        System.out.println("I am worker nr " + this.hashCode() + ". I know honey is..." + honeyAmount);
    }

}