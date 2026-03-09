/**
 * WaterMonster - attacks with water-based ability.
 */
public class WaterMonster extends Monster {

    public WaterMonster(String name) {
        super(name);
    }

    @Override
    public String attack() {
        return getName() + " unleashes a powerful tidal wave! 🌊";
    }
}
