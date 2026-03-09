
public abstract class Monster {

    private String name;

    public Monster(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract String attack();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[name=" + name + "]";
    }
}
