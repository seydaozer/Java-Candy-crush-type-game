/**
 * The atlantis property factory implements the properties using atlantis style.
 */
public class AtlantisPropertyFactory implements EntityPropertyFactory {
    /**
     * This is the value of the strength multiplier of the atlantis style.
     */
    private final double DEFAULT_STRENGTH = 0.8;
    /**
     * This is the value of the agility multiplier of the atlantis style.
     */
    private final double DEFAULT_AGILITY = 1.2;
    /**
     * This is the value of the health multiplier of the atlantis style.
     */
    private final double DEFAULT_HEALTH = 1.2;

    /**
     * This method returns the value of the strength multiplier of the atlantis style.
     * @return the value of the strength multiplier
     */
    @Override
    public double strengthMultiplier() {
        return DEFAULT_STRENGTH;
    }

    /**
     * This method returns the value of the agility multiplier of the atlantis style.
     * @return the value of the agility multiplier
     */
    @Override
    public double agilityMultiplier() {
        return DEFAULT_AGILITY;
    }

    /**
     * This method returns the value of the health multiplier of the atlantis style.
     * @return the value of the health multiplier
     */
    @Override
    public double healthMultiplier() {
        return DEFAULT_HEALTH;
    }
}
