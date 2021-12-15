import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 * The RedFireEntity class is a Concrete Product Class.
 * This RedFireEntity represents the Red/Fire type of the game entity.
 */
public class RedFireEntity extends Entity {
    /**
     * This is the value of the strength of the red/fire type entity.
     */
    private final int DEFAULT_STRENGTH = 100;
    /**
     * This is the value of the agility of the red/fire type entity.
     */
    private final int DEFAULT_AGILITY = 125;
    /**
     * This is the value of the health of the red/fire type entity.
     */
    private final int DEFAULT_HEALTH = 75;
    /**
     * The entity property factory provides the properties of the entity.
     */
    private EntityPropertyFactory propertyFactory;

    /**
     * RedFireEntity Constructor
     * It gets an entity property factory.
     * @param propertyFactory an entity property factory
     * @param x the initial x-coordinate of the red/fire entity
     * @param y the initial y-coordinate of the red/fire entity
     */
    public RedFireEntity(EntityPropertyFactory propertyFactory, int x, int y){
        this.propertyFactory = propertyFactory;
        this.x = x;
        this.y = y;
        this.color = Color.red;
        this.dead = false;
        df = new DecimalFormat("###.###");
    }

    /**
     * The Factory Method determines the initial values of the strength, agility and health of the red/fire type entity.
     * It gets the properties of the red/fire type entity from an entity property factory.
     */
    @Override
    public void initialize() {
        strength = DEFAULT_STRENGTH * propertyFactory.strengthMultiplier();
        agility = DEFAULT_AGILITY * propertyFactory.agilityMultiplier();
        health = DEFAULT_HEALTH * propertyFactory.healthMultiplier();
    }

    /**
     * This method draws the images of the red/fire entity.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        if(!dead)
            g.drawImage(Assets.fireEntity,x,y,Entity.DEFAULT_WIDTH,Entity.DEFAULT_HEIGHT, null);
        else
            g.drawImage(Assets.deadFireEntity, x,y,Entity.DEFAULT_WIDTH,Entity.DEFAULT_HEIGHT,null);
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(name, x+5, y+12);
        String healthVal = df.format(health);
        g.drawString("Health: " + healthVal, x+5, y+97);
    }
}
