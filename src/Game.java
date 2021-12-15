import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * This class runs the game.
 */
public class Game implements Runnable {
    /**
     * This variable is false if the game has not started.
     * When the game starts, this variable becomes true.
     */
    private boolean running;
    /**
     * The game thread
     */
    private Thread thread;
    /**
     * It is used to display the game.
     */
    private Display display;
    /**
     * This is width of the game window.
     */
    private int width;
    /**
     * This is height of the game window.
     */
    private int height;
    /**
     * This String is title of the game.
     */
    public String title;
    /**
     * This is used to listen mouse inputs.
     */
    private MouseManager mouseManager;
    /**
     * This is the game state for the game
     * It is initial state
     */
    private State gameState;
    /**
     * This is the buffer strategy of the game canvas.
     * Using this, the Graphics g is obtained for drawing on the canvas.
     * It shows the drawings.
     */
    private BufferStrategy bs;
    /**
     * This is used to draw on canvas.
     */
    private Graphics g;
    /**
     * This is FPS value of the game.
     */
    private int fps;

    /**
     * Game Constructor
     * @param title title of the game
     * @param width width value of the game window
     * @param height height value of the game window
     */
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        running = false;
        mouseManager = new MouseManager();
        fps = 45; // it is the amount of time so we want to call the tick and render method every second
    }

    /**
     * This method initializes the game.
     */
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        Assets.init();

        gameState = new GameState(this);
        State.setState(gameState);
    }

    /**
     * This method gets the mouse inputs
     */
    private void tick(){
        if(State.getState() != null){
            State.getState().tick();
        }
    }

    /**
     * This method shows the drawings for the game.
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0,0, width, height);
        // Draw Here!
        if(State.getState() != null){
            State.getState().render(g);
        }
        // End Drawing!
        bs.show();
        g.dispose();
    }

    /**
     * This method runs the game.
     */
    @Override
    public void run(){
        init();

        double timePerTick = 1000000000 / fps;
        // maximum amount of time in nanoseconds that we have to execute the tick and render methods
        // that way we are able to achieve our 60 frames per second target
        double delta = 0; // it is essentially the amount of time have until we have to call the tick and render methods again
        long now;
        long lastTime = System.nanoTime();

        while(running){
            timePerTick = 1000000000 / fps;
            now = System.nanoTime(); // this is initialized at beginning
            delta += (now - lastTime) / timePerTick; // and we do a bunch of fancy division here
            // to get it so that it is somewhere between 0 and 1 when we add to
            lastTime = now;

            if(delta >= 1) { // that means we have to tick and render or we are not going to get to 60 fps
                tick();
                render();
                delta--; // okey we ticked one more time and delta can relax
            }
        }
        stop();
    }

    /**
     * This method starts the game.
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * this method stops the game.
     */
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the mouse manager of the game
     * @return MouseManager object
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /**
     * Gets the title of the game.
     * @return the game title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the width of the game canvas.
     * @return the game canvas width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the game canvas.
     * @return the game canvas height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the FPS value of the game
     * @return the current FPS value
     */
    public int getFps() {
        return fps;
    }

    /**
     * Sets the FPS value of the game
     * @param fps th enew value of the FPS
     */
    public void setFps(int fps) {
        this.fps = fps;
    }
}
