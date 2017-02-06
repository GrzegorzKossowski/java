package mainapp.entity;

/**
 * PirateIsland
 * Created by Grzegorz Kossowski on 02.02.17.
 */
public class Adventure {

    private String name;

    public Adventure() {}

    public Adventure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Adventure{" +
                "name='" + name + '\'' +
                '}';
    }
}
