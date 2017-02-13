package app.creational.prototype.model;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 13.02.17.
 */
public abstract class Element implements Cloneable {

    private String id;
    private ElementType type;

    public abstract void scream();

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
