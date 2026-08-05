class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Object Created");
    }

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void display() {
        System.out.println("Hello Singleton");
    }
}

public class SingletonPattern {

    public static void main(String[] args) {

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.display();
        obj2.display();

        System.out.println(obj1 == obj2);
    }
}