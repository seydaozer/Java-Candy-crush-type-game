/**
 * EntityPropertyFactory is implemented as an Abstract Factory
 * because we need to create families of entity properties.
 * Each subclass implements the properties using its own style.
 */
public interface EntityPropertyFactory {

    /**
     * This method returns the value of the strength multiplier of the style.
     * @return the value of the strength multiplier
     */
    public double strengthMultiplier();

    /**
     * This method returns the value of the agility multiplier of the style.
     * @return the value of the agility multiplier
     */
    public double agilityMultiplier();

    /**
     * This method returns the value of the health multiplier of the style.
     * @return the value of the health multiplier
     */
    public double healthMultiplier();

}
