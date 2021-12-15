import java.awt.Graphics;
import java.awt.Color;

/**
 * GameOverState Class
 * The Class is the game over state of the game.
 */
public class GameOverState extends State {

    /**
     * GameOverState Constructor
     * @param game Game object of the current game
     */
    public GameOverState(Game game){
        super(game);
        game.setFps(45);
    }

    /**
     * This method gets new game and exit buttons inputs.
     */
    @Override
    public void tick() {
        if(game.getMouseManager().restart) {
            setState(new GameState(game));
        }
        if(game.getMouseManager().exit) {
            System.exit(1);
        }
    }

    /**
     * This function draws the "Game Over!" images and buttons.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        Color c = new Color(0,100,0);
        g.setColor(c);
        g.fillRect(0,0, game.getWidth(), game.getHeight());
        g.drawImage(Assets.gameOver, 115, 250, 200,100, null);
        g.drawImage(Assets.restartButton, 150, 175, 50,50,null);
        g.drawImage(Assets.exitButton, 230, 175, 50,50,null);
    }
}
