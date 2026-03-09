public class FireMonster extends Monster {

    public FireMonster(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return getName() + " breathes a massive fireball! 🔥";
    }
}
