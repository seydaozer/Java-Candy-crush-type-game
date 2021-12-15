import java.awt.Color;
import java.awt.Graphics;

/**
 *  This class represents the tiles of the game.
 *  The tiles: Blue tile, Red tile, Green tile.
 */
public abstract class Tile {
    /**
     * This is default value of the width tile image.
     */
    public static final int DEFAULT_WIDTH = 45;
    /**
     * This is default value of the height tile image.
     */
    public static final int DEFAULT_HEIGHT = 45;
    /**
     * This is current game
     */
    protected Game game;
    /**
     * This is width of the tile.
     */
    protected int width;
    /**
     * This is height of the tile.
     */
    protected int height;
    /**
     * This is color of the tile.
     */
    protected Color color;
    /**
     * This is x-coordinate for the tile
     */
    protected int x;
    /**
     * This is y-coordinate for the tile
     */
    protected int y;
    /**
     * This flag becomes true if the tile matches the others.
     */
    protected boolean match;

    /**
     * Tile Constructor
     * @param game Game object of the current game
     * @param x the initial x-coordinate
     * @param y the initial y-coordinate
     */
    public Tile(Game game, int x , int y){
        this.game = game;
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        this.x = x;
        this.y = y;
        match = false;
    }

    /**
     * This method draws the image of the tile.
     * @param g Graphics object is used to draw tile image.
     */
    public abstract void render(Graphics g);

    /**
     * Gets the color of the tile.
     * @return the current color of the tile
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the tile.
     * @param color the new color of the tile.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the x-coordinate of the tile.
     * @return the current x-coordinate of the tile.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the tile.
     * @param x the new x-coordinate of the tile.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the tile.
     * @return the current y-coordinate of the tile.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the tile.
     * @param y the new y-coordinate of the tile.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the match value of the tile.
     * @return true if the tile matches the others.
     */
    public boolean isMatch() {
        return match;
    }

    /**
     * Sets the match value of the tile.
     * @param match the new match value of the tile.
     */
    public void setMatch(boolean match) {
        this.match = match;
    }
}
