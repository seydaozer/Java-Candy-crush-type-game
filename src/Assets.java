import java.awt.image.BufferedImage;

/**
 * This class contains the necessary images for the game.
 */
public class Assets {
    /**
     * The BufferedImage used for blue/ice entity image of the game.
     */
    public static BufferedImage iceEntity;
    /**
     * The BufferedImage used for red/fire image of the game.
     */
    public static BufferedImage fireEntity;
    /**
     * The BufferedImage used for green/nature image of the game.
     */
    public static BufferedImage natureEntity;
    /**
     * The BufferedImage array contains tiles images of the game.
     * colors of the tiles: blue = 0, red = 1, green = 2.
     */
    public static BufferedImage[] tiles;
    /**
     * The BufferedImage used for game over text image of the game.
     */
    public static BufferedImage gameOver;
    /**
     * The BufferedImage used for exit button image of the game.
     */
    public static BufferedImage exitButton;
    /**
     * The BufferedImage used for pause button image of the game.
     */
    public static BufferedImage pauseButton;
    /**
     * The BufferedImage used for restart button image of the game.
     */
    public static BufferedImage restartButton;
    /**
     * The BufferedImage used for resume button image of the game.
     */
    public static BufferedImage resumeButton;
    /**
     * The BufferedImage used for dead blue/ice entity image of the game.
     */
    public static BufferedImage deadIceEntity;
    /**
     * The BufferedImage used for dead red/fire image of the game.
     */
    public static BufferedImage deadFireEntity;
    /**
     * The BufferedImage used for dead green/nature image of the game.
     */
    public static BufferedImage deadNatureEntity;


    /**
     * The init method loads images for use in the game.
     */
    public static void init(){
        iceEntity = ImageLoader.loadImage("blue_golem.png");
        fireEntity = ImageLoader.loadImage("red_golem.png");
        natureEntity = ImageLoader.loadImage("green_golem.png");
        deadIceEntity = ImageLoader.loadImage("deadBlueGolem.png");
        deadFireEntity = ImageLoader.loadImage("deadRedGolem.png");
        deadNatureEntity = ImageLoader.loadImage("deadGreenGolem.png");

        tiles = new BufferedImage[4];
        tiles[0] = ImageLoader.loadImage("blue_tile.png");
        tiles[1] = ImageLoader.loadImage("red_tile.png");
        tiles[2] = ImageLoader.loadImage("greenTile.png");
        tiles[3] = ImageLoader.loadImage("empty_tile.png");

        gameOver = ImageLoader.loadImage("game_over.png");

        exitButton = ImageLoader.loadImage("exitButton.png");
        pauseButton = ImageLoader.loadImage("pauseButton.png");
        restartButton = ImageLoader.loadImage("restartButton.png");
        resumeButton = ImageLoader.loadImage("startButton.png");
    }

}
