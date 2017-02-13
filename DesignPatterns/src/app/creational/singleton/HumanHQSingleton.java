package app.creational.singleton;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 12.02.17.
 *
 * Auto ThreadSafe Singleton Pattern:
 *
 */
public class HumanHQSingleton {

    private static final Object instance = new Object();

    protected HumanHQSingleton() {}

    public static Object getInstance() {
        return instance;
    }


}
