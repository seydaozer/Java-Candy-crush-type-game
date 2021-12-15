import java.awt.event.*;

/**
 * This class is used to listen mouse inputs.
 */
public class MouseManager extends MouseAdapter {
    /**
     * This array contains the tiles of the game.
     * The pressed tile becomes true. The released tile becomes false.
     */
    public boolean tiles[][];
    /**
     * This variable represents the exit button for game over state.
     * Its value becomes true, when exit button is pressed.
     * Its value becomes false, when exit button is released.
     */
    public boolean exit;
    /**
     * This variable represents the start new game button.
     * Its value becomes true, when start new game button is pressed.
     * Its value becomes false, when start new game button is released.
     */
    public boolean restart;
    /**
     * This variable represents the pause button.
     * Its value becomes true, when pause button is pressed.
     * Its value becomes false, when pause button is released.
     */
    public boolean pause;
    /**
     * This variable represents the resume button.
     * Its value becomes true, when resume button is pressed.
     * Its value becomes false, when resume button is released.
     */
    public boolean resume;
    /**
     * The click number
     * It is used to store the last click. Thus, the tiles can be swapped with each other easily.
     */
    private int click;
    /**
     * the row value of the previous moving tile
     */
    private int prev_i;
    /**
     * the column value of the previous moving tile
     */
    private int prev_j;

    /**
     * MouseManager Constructor
     */
    public MouseManager(){
        tiles = new boolean[6][9];
        prev_i = -1;
        prev_j = -1;
        click = 0;
    }

    /**
     * This method resets the remaining information for the new game state.
     */
    public void reset(){
        prev_i = -1;
        prev_j = -1;
        click = 0;
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(click == 2)
            click = 0;
        click++;

        int mx = e.getX();
        int my = e.getY();

        if(mx > 0 && mx < 50)
            findPressedTile(0, my);

        else if(mx > 50 && mx < 100)
            findPressedTile(1, my);

        else if(mx > 100 && mx < 150)
            findPressedTile(2, my);

        else if(mx > 150 && mx < 200)
            findPressedTile(3, my);

        else if(mx > 200 && mx < 250)
            findPressedTile(4, my);

        else if(mx > 250 && mx < 300)
            findPressedTile(5, my);

        else if(mx > 300 && mx < 350)
            findPressedTile(6, my);

        else if(mx > 350 && mx < 400)
            findPressedTile(7, my);

        else if(mx > 400 && mx < 450)
            findPressedTile(8, my);


        // Game Over State Buttons
        if(my >= 175 && my <= 225){
            // start new game button
            if(mx >= 150 && mx <= 200)
                restart = true;
            // exit button
            else if(mx >= 230 && mx <= 280)
                exit = true;
        }

        // Game State Buttons
        // top menu
        if(mx >= 400 && mx <= 432) {
            if (my >= 10 && my <= 42)
                pause = true;
        }
        // resume button
        if(mx >= 200 && mx <= 250){
            if(my >= 200 && my <= 250)
                resume = true;
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                tiles[i][j] = false;
            }
        }
        exit = false;
        restart = false;
        pause = false;
        resume = false;
    }

    /**
     * This method finds the pressed tile.
     * @param j the j value indicates which column the pressed tile is in.
     * @param my the y-coordinate of the mouse
     */
    private void findPressedTile(int j, int my){
        if(my > 300 && my < 350){
            tiles[0][j] = true;
            if(click != 2) {
                prev_i = 0;
                prev_j = j;
            }
        }
        else if(my > 350 && my < 400){
            tiles[1][j] = true;
            if(click != 2) {
                prev_i = 1;
                prev_j = j;
            }
        }
        else if(my > 400 && my < 450){
            tiles[2][j] = true;
            if(click != 2) {
                prev_i = 2;
                prev_j = j;
            }
        }
        else if(my > 450 && my < 500){
            tiles[3][j] = true;
            if(click != 2) {
                prev_i = 3;
                prev_j = j;
            }
        }
        else if(my > 500 && my < 550){
            tiles[4][j] = true;
            if(click != 2) {
                prev_i = 4;
                prev_j = j;
            }
        }
        else if(my > 550 && my < 600) {
            tiles[5][j] = true;
            if(click != 2) {
                prev_i = 5;
                prev_j = j;
            }
        }

    }

    /**
     * Gets the row value of the previous moving tile.
     * @return the row value of the previous moving tile
     */
    public int getPrev_i() {
        return prev_i;
    }

    /**
     * Sets the row value of the previous moving tile.
     * @param prev_i the new row value of the previous moving tile
     */
    public void setPrev_i(int prev_i) {
        this.prev_i = prev_i;
    }

    /**
     * Gets the column value of the previous moving tile.
     * @return the column value of the previous moving tile
     */
    public int getPrev_j() {
        return prev_j;
    }

    /**
     * Sets the column value of the previous moving tile.
     * @param prev_j the new column value of the previous moving tile
     */
    public void setPrev_j(int prev_j) {
        this.prev_j = prev_j;
    }
}
