package SwordToOffer.Public;

public class Singleton {
    private Singleton() {
    }

    private static Singleton singleton;

    public static Singleton getInstance() {
        return singleton;
    }

}
