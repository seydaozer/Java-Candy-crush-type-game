/**
 * The underwild property factory implements the properties using underwild style.
 */
public class UnderwildPropertyFactory  implements EntityPropertyFactory {
    /**
     * This is the value of the strength multiplier of the underwild style.
     */
    private final double DEFAULT_STRENGTH = 0.8;
    /**
     * This is the value of the agility multiplier of the underwild style.
     */
    private final double DEFAULT_AGILITY = 1.6;
    /**
     * This is the value of the health multiplier of the underwild style.
     */
    private final double DEFAULT_HEALTH = 0.8;

    /**
     * This method returns the value of the strength multiplier of the underwild style.
     * @return the value of the strength multiplier
     */
    @Override
    public double strengthMultiplier() {
        return DEFAULT_STRENGTH;
    }

    /**
     * This method returns the value of the agility multiplier of the underwild style.
     * @return the value of the agility multiplier
     */
    @Override
    public double agilityMultiplier() {
        return DEFAULT_AGILITY;
    }

    /**
     * This method returns the value of the health multiplier of the underwild style.
     * @return the value of the health multiplier
     */
    @Override
    public double healthMultiplier() {
        return DEFAULT_HEALTH;
    }
}
