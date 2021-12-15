import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 * The BlueIceEntity class is a Concrete Product Class.
 * This BlueIceEntity represents the Blue/Ice type of the game entity.
 */
public class BlueIceEntity extends Entity{
    /**
     * This is the value of the strength of the blue/ice type entity.
     */
    private final int DEFAULT_STRENGTH = 125;
    /**
     * This is the value of the agility of the blue/ice type entity.
     */
    private final int DEFAULT_AGILITY = 75;
    /**
     * This is the value of the health of the blue/ice type entity.
     */
    private final int DEFAULT_HEALTH = 100;
    /**
     * The entity property factory provides the properties of the entity.
     */
    private EntityPropertyFactory propertyFactory;

    /**
     * BlueIceEntity Constructor
     * It gets an entity property factory.
     * @param propertyFactory an entity property factory
     * @param x the initial x-coordinate of the blue/ice entity
     * @param y the initial y-coordinate of the blue/ice entity
     */
    public BlueIceEntity(EntityPropertyFactory propertyFactory, int x, int y){
        this.propertyFactory = propertyFactory;
        this.x = x;
        this.y = y;
        this.color = Color.blue;
        this.dead = false;
        df = new DecimalFormat("###.###");
    }

    /**
     * The Factory Method determines the initial values of the strength, agility and health of the blue/ice type entity.
     * It gets the properties of the blue/ice type entity from an entity property factory.
     */
    @Override
    public void initialize() {
        strength = DEFAULT_STRENGTH * propertyFactory.strengthMultiplier();
        agility = DEFAULT_AGILITY * propertyFactory.agilityMultiplier();
        health = DEFAULT_HEALTH * propertyFactory.healthMultiplier();
    }

    /**
     * This method draws the images of the blue/ice entity.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        if(!dead)
            g.drawImage(Assets.iceEntity, x, y, Entity.DEFAULT_WIDTH,Entity.DEFAULT_HEIGHT,null);
        else
            g.drawImage(Assets.deadIceEntity, x, y, Entity.DEFAULT_WIDTH,Entity.DEFAULT_HEIGHT,null);
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(name, x, y+12);
        String healthVal = df.format(health);
        g.drawString("Health: " + healthVal, x, y+97);
    }

}
