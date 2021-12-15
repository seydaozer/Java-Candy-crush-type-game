import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

/**
 * The Entity class is a Product Class.
 * This Entity represents the enemies and the player characters.
 * It has 3 types: Blue/Ice, Red/Fire, Green/Nature
 * and 3 styles: Atlantis, Valhalla, Underwild.
 */
public abstract class Entity {
    /**
     * This is default value of the width entity image.
     */
    public static final int DEFAULT_WIDTH = 100;
    /**
     * This is default value of the height entity image.
     */
    public static final int DEFAULT_HEIGHT = 100;
    /**
     * It is the name of the entity.
     */
    protected String name;
    /**
     * It is the strength of the entity.
     * Strength determines the damage the computer/player will perform
     * when matching tiles of the color corresponding to the color of that entity.
     */
    protected double strength;
    /**
     * It is the agility of the entity.
     * Agility determines the defense of the entity against attacks.
     */
    protected double agility;
    /**
     * It is the health of the entity.
     */
    protected double health;
    /**
     * This is x-coordinate for the entity
     */
    protected int x;
    /**
     * This is y-coordinate for the entity
     */
    protected int y;
    /**
     * This is style of the entity.
     * Styles: atlantis = 0, valhalla = 1, underwild = 2
     */
    protected int style;
    /**
     * This is color of the entity. (blue, red, green)
     */
    protected Color color;
    /**
     * When the entity dies, its value becomes true.
     */
    protected boolean dead;
    /**
     * It used to format double values as ###.###.
     */
    DecimalFormat df;

    /**
     * The Factory Method determines the initial values of the strength, agility and health of the entity.
     * It gets the properties of the entity from an entity property factory.
     */
    public abstract void initialize();

    /**
     * This method calculates the value of the damage that matched tiles result on an enemy/character.
     * @return value of the damage
     */
    public double damage(){
        return 100 * Math.pow((strength / agility), 1.35);
    }

    /**
     * This method draws the images of the entity.
     * @param g Graphics object is used to draw
     */
    public abstract void render(Graphics g);

    /**
     * The entity's health is reduced when it takes damage.
     * @param damage the value of the damage.
     */
    public void reduceHealth(double damage){
        health -= damage;

        if(health <= 0){
            dead = true;
            health = 0;
        }
    }

    /**
     * Gets the name of the entity.
     * @return current name of the entity
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the entity
     * @param name new name for the entity
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the strength value of the entity.
     * @return the current value of strength
     */
    public double getStrength() {
        return strength;
    }

    /**
     * Sets the strength value of the entity.
     * @param strength the new value of strength
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }

    /**
     * Gets the agility value of the entity.
     * @return the current value of agility
     */
    public double getAgility() {
        return agility;
    }

    /**
     * Sets the agility value of the entity.
     * @param agility the new value of agility
     */
    public void setAgility(double agility) {
        this.agility = agility;
    }

    /**
     * Gets the health value of the entity.
     * @return the current value of health
     */
    public double getHealth() {
        return health;
    }

    /**
     * Sets the health value of the entity.
     * @param health the new value of health
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Gets the style of the entity (atlantis or valhalla or undderwild)
     * @return the current style
     */
    public int getStyle() {
        return style;
    }

    /**
     * Sets the style the entity.
     * @param style the new value of style (atlantis or valhalla or undderwild)
     */
    public void setStyle(int style) {
        this.style = style;
    }

    /**
     * Gets the color of the entity
     * @return the current color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color the entity.
     * @param color the new color of the entity
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the dead value of the entity.
     * @return true if the entity is dead. Otherwise, false.
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the dead value of the entity
     * @param dead the new dead value
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

}
