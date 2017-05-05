package app.behavioral.strategy;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 09.04.17.
 */
public class Strategy {

    public static void main(String[] args) {
        Bee gucio = new Worker();
        System.out.println(gucio.getRank());

        //promote to hard worker
        gucio.setRank(new HardWorkerRank());
        System.out.println(gucio.getRank());

        //promote to queen
        gucio = new Queen();
        System.out.println(gucio.getRank());

        //unlucky degradation
        gucio = new Worker();
        System.out.println(gucio.getRank());



    }
}

//-------------Ranks

interface Rank {
    String getRank();
}

class WorkerRank implements Rank {
    @Override
    public String getRank() {
        return "Worker";
    }
}

class HardWorkerRank implements Rank {
    @Override
    public String getRank() {
        return "Hard Worker";
    }
}

class QueenRank implements Rank {
    @Override
    public String getRank() {
        return "The Queen";
    }
}

//---------------Bees

abstract class Bee {
    Rank rank;

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank.getRank();
    }
}

class Worker extends Bee {

    public Worker() {
        rank = new WorkerRank();
    }

}

class Queen extends Bee {

    public Queen() {
        rank = new QueenRank();
    }

}