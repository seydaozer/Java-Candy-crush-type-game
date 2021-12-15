import java.awt.Color;

/**
 * This is the simple tile factory class.
 * It creates tiles.
 */
public class SimpleTileFactory {

    /**
     * This method create a tile for given color type (integer value: 0 - 1 - 2).
     * @param game Game object of the current game
     * @param c this integer value is the color type (blue=0, red=1, green=2).
     * @param x the initial x-coordinate of the tile
     * @param y the initial y-coordinate of the tile
     * @return created tile
     */
    public static Tile createTile(Game game, int c, int x, int y){
        Tile tile;
        if(c == 0){ // BLUE
            tile = new BlueTile(game, x, y);
        } else if(c == 1){ // RED
            tile = new RedTile(game, x, y);
        } else if(c == 2){ // GREEN
            tile = new GreenTile(game, x, y);
        } else{
            System.out.println("Error: invalid color of game tile.");
            return null;
        }
        return tile;
    }

    /**
     * This method create a tile for given color (blue, red, green).
     * @param game Game object of the current game
     * @param c this is the color of the tile
     * @param x the initial x-coordinate of the tile
     * @param y the initial y-coordinate of the tile
     * @return created tile
     */
    public static Tile createTile(Game game, Color c, int x, int y){
        Tile tile;
        if(c == Color.blue){
            tile = new BlueTile(game, x, y);
        } else if(c == Color.red){
            tile = new RedTile(game, x, y);
        } else if(c == Color.green){
            tile = new GreenTile(game, x, y);
        } else{
            System.out.println("Error: invalid color of game tile.");
            return null;
        }
        return tile;
    }
}
