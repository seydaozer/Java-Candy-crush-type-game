/**
 * This class launch the game.
 */
public class Launcher {
    /**
     * Main function tests the game.
     * @param args command-line arguments
     */
    public static void main(String[] args){
        Game game = new Game("Campuses and Puzzles", 450, 640);
        game.start();
    }
}
