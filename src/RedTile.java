import java.awt.Graphics;
import java.awt.Color;

/**
 * This class represents the red tiles of the game.
 */
public class RedTile extends Tile {

    /**
     * RedTile Constructor
     * @param game Game object of the current game
     * @param x the initial x-coordinate
     * @param y the initial y-coordinate
     */
    public RedTile(Game game, int x, int y) {
        super(game,x , y);
        color = Color.red;
    }

    /**
     * This method draws the image of the red tile.
     * @param g Graphics object is used to draw red tile image.
     */
    @Override
    public void render(Graphics g) {
        if(!match)
            g.drawImage(Assets.tiles[1], x, y, width, height, null);
        else
            g.drawImage(Assets.tiles[3], x, y, width, height, null);
    }
}
