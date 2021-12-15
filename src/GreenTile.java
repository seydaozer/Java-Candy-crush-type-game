import java.awt.Graphics;
import java.awt.Color;

/**
 * This class represents the green tiles of the game.
 */
public class GreenTile extends Tile {

    /**
     * GreenTile Constructor
     * @param game Game object of the current game
     * @param x the initial x-coordinate
     * @param y the initial y-coordinate
     */
    public GreenTile(Game game, int x, int y) {
        super(game,x , y);
        color = Color.green;
    }

    /**
     * This method draws the image of the green tile.
     * @param g Graphics object is used to draw green tile image.
     */
    @Override
    public void render(Graphics g) {
        if(!match)
            g.drawImage(Assets.tiles[2], x, y, width, height, null);
        else
            g.drawImage(Assets.tiles[3], x, y, width, height, null);
    }
}
