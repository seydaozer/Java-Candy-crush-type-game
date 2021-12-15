import java.awt.Graphics;
import java.awt.Color;

/**
 * This class represents the blue tiles of the game.
 */
public class BlueTile extends Tile {

    /**
     * BlueTile Constructor
     * @param game Game object of the current game
     * @param x the initial x-coordinate
     * @param y the initial y-coordinate
     */
    public BlueTile(Game game, int x, int y) {
        super(game,x , y);
        color = Color.blue;
    }

    /**
     * This method draws the image of the blue tile.
     * @param g Graphics object is used to draw blue tile image.
     */
    @Override
    public void render(Graphics g) {
        if(!match)
            g.drawImage(Assets.tiles[0], x, y, width, height, null);
        else
            g.drawImage(Assets.tiles[3], x, y, width, height, null);
    }
}
