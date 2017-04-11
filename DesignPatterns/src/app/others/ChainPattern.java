package app.others;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 02.03.17.
 */
public class ChainPattern {

    private String name;
    private int value;

    public ChainPattern setName(String name) {
        this.name = name;
        return this;
    }

    public ChainPattern setValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "ChainPattern{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
