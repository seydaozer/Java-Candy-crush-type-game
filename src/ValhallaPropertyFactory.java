/**
 * The valhalla property factory implements the properties using valhalla style.
 */
public class ValhallaPropertyFactory implements EntityPropertyFactory {
    /**
     * This is the value of the strength multiplier of the valhalla style.
     */
    private final double DEFAULT_STRENGTH = 1.3;
    /**
     * This is the value of the agility multiplier of the valhalla style.
     */
    private final double DEFAULT_AGILITY = 0.4;
    /**
     * This is the value of the health multiplier of the valhalla style.
     */
    private final double DEFAULT_HEALTH = 1.3;

    /**
     * This method returns the value of the strength multiplier of the valhalla style.
     * @return the value of the strength multiplier
     */
    @Override
    public double strengthMultiplier() {
        return DEFAULT_STRENGTH;
    }

    /**
     * This method returns the value of the agility multiplier of the valhalla style.
     * @return the value of the agility multiplier
     */
    @Override
    public double agilityMultiplier() {
        return DEFAULT_AGILITY;
    }

    /**
     * This method returns the value of the health multiplier of the valhalla style.
     * @return the value of the health multiplier
     */
    @Override
    public double healthMultiplier() {
        return DEFAULT_HEALTH;
    }
}
