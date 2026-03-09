public class TestMonster {
    public static void triggerAttack(Monster m) {
        System.out.println(m);
        System.out.println("  Attack: " + m.attack());
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Upcasting: Superclass References → Subclass Instances ===");

        Monster m1 = new FireMonster("Inferno");     // upcast
        Monster m2 = new WaterMonster("Tsunami");    // upcast
        Monster m3 = new StoneMonster("Golem");      // upcast

        triggerAttack(m1);
        triggerAttack(m2);
        triggerAttack(m3);

        System.out.println("\n=== 2. Polymorphism via Monster Array ===");

        Monster[] monsters = {
            new FireMonster("Blaze"),
            new WaterMonster("Surge"),
            new StoneMonster("Boulder"),
            new FireMonster("Ember")
        };

        for (Monster m : monsters) {
            System.out.println(m.attack());
        }

        System.out.println("\n=== 3. Reassignment of Superclass Reference ===");

        Monster shapeshifter = new FireMonster("Phoenix");
        System.out.println("Before reassignment:");
        System.out.println("  Type: " + shapeshifter.getClass().getSimpleName());
        System.out.println("  " + shapeshifter.attack());

        shapeshifter = new StoneMonster("Titan");
        System.out.println("After reassignment:");
        System.out.println("  Type: " + shapeshifter.getClass().getSimpleName());
        System.out.println("  " + shapeshifter.attack());

        shapeshifter = new WaterMonster("Hydra");
        System.out.println("After second reassignment:");
        System.out.println("  Type: " + shapeshifter.getClass().getSimpleName());
        System.out.println("  " + shapeshifter.attack());

        System.out.println("\n=== 4. Direct Instantiation of Abstract Superclass ===");

        try {
            Monster.class.getDeclaredConstructor(String.class).newInstance("Unknown");
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate Monster directly!");
            System.out.println("Reason: Monster is an abstract class. (InstantiationException)");
        } catch (IllegalAccessException | NoSuchMethodException
                | java.lang.reflect.InvocationTargetException e) {
            System.out.println("Cannot instantiate Monster directly!");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("\nMonster must be instantiated through a concrete subclass:");
        System.out.println("  e.g. Monster m = new FireMonster(\"Spark\");");
        Monster safe = new FireMonster("Spark");
        System.out.println("  " + safe.attack());
    }
}
