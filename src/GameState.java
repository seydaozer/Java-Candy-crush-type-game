import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

/**
 * This class is the game state of the game.
 */
public class GameState extends State {
    /**
     * The Tile array contains tiles of the game.
     * colors of the tiles: blue, red, green.
     */
    private Tile[][] tiles;
    /**
     * If matching tiles are found, its value will be true. Otherwise, false.
     */
    private boolean isMatch;
    /**
     * The row value of the first of the matching tiles.
     */
    private int row;
    /**
     * The column value of the first of the matching tiles.
     */
    private int column;
    /**
     * Match type
     * 0 : horizontal match
     * 1 : vertical match
     */
    private int type;
    /**
     * If there is a swap operation, its value will be true. Otherwise, false.
     */
    private boolean isSwitch;
    /**
     * The row value of the first of the switched tiles.
     */
    private int switched_i1;
    /**
     * The column value of the first of the switched tiles.
     */
    private int switched_j1;
    /**
     * The row value of the second of the switched tiles.
     */
    private int switched_i2;
    /**
     * The column value of the second of the switched tiles.
     */
    private int switched_j2;
    /**
     * This variable is initially false.
     * It becomes true if the player presses the pause button.
     */
    private boolean paused;
    /**
     * The first entity of the character.
     */
    private Entity C1;
    /**
     * The second entity of the character.
     */
    private Entity C2;
    /**
     * The third entity of the character.
     */
    private Entity C3;
    /**
     * The first entity of the computer.
     */
    private Entity E1;
    /**
     * The second entity of the computer.
     */
    private Entity E2;
    /**
     * The third entity of the computer.
     */
    private Entity E3;
    /**
     * This variable is true, if it is the player's turn to play.
     */
    private boolean playerTurn;
    /**
     * It is the owner of the last matching tiles.
     * 0 = player, 1 = computer
     */
    private int ownerLastMove;
    /**
     * The status message of the game.
     */
    private String statusMessage;

    /**
     * GameState Constructor
     * @param game Game object of the current game
     */
    public GameState(Game game){
        super(game);
        game.getMouseManager().reset();
        tiles = new Tile[6][9];
        init_tiles();
        init_entities();
        isMatch = false;
        row = 0;
        column = 0;
        type = -1;
        isSwitch = false;
        playerTurn = true;
        ownerLastMove = -1;
        statusMessage = "";
        paused = false;
    }

    /**
     * This method randomly fills the tiles.
     */
    private void init_tiles(){
        Random rand = new Random();

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                int color = rand.nextInt(3);
                tiles[i][j] = SimpleTileFactory.createTile(game, color, 2 + j*50, 302 + i*50);
            }
        }
    }

    /**
     * this method randomly creates player's and computer's entities.
     */
    private void init_entities(){
        C1 = SimpleEntityFactory.createEntity(25,50);
        C2 = SimpleEntityFactory.createEntity(175,50);
        C3 = SimpleEntityFactory.createEntity(325,50);

        E1 = SimpleEntityFactory.createEntity(25,175);
        E2 = SimpleEntityFactory.createEntity(175,175);
        E3 = SimpleEntityFactory.createEntity(325,175);
    }

    /**
     * This method gets mouse inputs and updates the tiles.
     */
    @Override
    public void tick() {
        if(C1.isDead() && C2.isDead() && C3.isDead()){
            State.setState(new GameOverState(game));
        }
        if(E1.isDead() && E2.isDead() && E3.isDead()){
            State.setState(new GameState(game));
        }

        getButtonInput();
        if(paused)  return;

        if(!isMatch) {
            // there is no match and there is a switch
            if(isSwitch){
                switchTile(switched_i2, switched_j2, switched_i1, switched_j1);
                isSwitch = false;
                // The game returns to normal speed.
                game.setFps(45);
            }

            if(!checkMatchingTiles()) {
                if (playerTurn) {
                    statusMessage = "Player turn: ";
                    getInput();
                    if(isSwitch && checkMatchingTiles())
                        ownerLastMove = 0;
                }
                else {
                    statusMessage = "Computer turn: ";
                    computerMove();
                    if(isSwitch && checkMatchingTiles())
                        ownerLastMove = 1;
                }
            }
            checkMatchingTiles();

        }
        if(isMatch){
            fillEmptyTiles();
            row++;
            if(row == 6) {
                isMatch = false;
                // The game returns to normal speed.
                game.setFps(45);
            }
        }
    }

    /**
     * This method draws the images and strings required in the game state.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 15));

        // 450 x 640
        g.setColor(Color.lightGray);
        g.fillRect(0,0, game.getWidth(), game.getHeight());

        g.setColor(Color.darkGray);
        if(ownerLastMove == 0)
            g.drawString("Last attack: Player", 15,30);
        else if(ownerLastMove == 1)
            g.drawString("Last attack: Computer", 15,30);

        g.drawImage(Assets.pauseButton, 400,10,32,32, null);

        g.setColor(Color.black);
        g.drawRect(12, 50, 125,100); // c1
        g.drawRect(162, 50, 125,100); // c2
        g.drawRect(312, 50, 125,100); // c3

        g.drawRect(12, 175, 125,100); // e1
        g.drawRect(162, 175, 125,100); // e2
        g.drawRect(312, 175, 125,100); // e3

        C1.render(g);
        C2.render(g);
        C3.render(g);
        E1.render(g);
        E2.render(g);
        E3.render(g);

        // 300 x 450
        g.drawRect(0, 300, game.getWidth(), 300);
        drawTiles(g);

        g.setColor(Color.DARK_GRAY);
        g.drawString(statusMessage, 10, 625);

        if(paused)
            g.drawImage(Assets.resumeButton, 200, 200,50,50,null);
    }

    /**
     * This method draws the tiles.
     * @param g Graphics object is used to draw
     */
    private void drawTiles(Graphics g){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                if(tiles[i][j] != null)
                    tiles[i][j].render(g);
            }
        }
    }

    /**
     * This function gets the mouse inputs for the pause and resume buttons.
     */
    private void getButtonInput(){
        if(game.getMouseManager().pause)
            paused = true;
        if(game.getMouseManager().resume)
            paused = false;
    }

    /**
     * The computer does random motion.
     */
    private void computerMove(){
        Random rand = new Random();
        // direction of the move
        // 0 = left, 1 = right, 2 = up, 3 = down
        int direction = rand.nextInt(4);

        // the position of the tile to move
        int i = rand.nextInt(6);
        int j = rand.nextInt(9);

        // left
        if(direction == 0){
            if(j == 0)  j = 1;
            switchTile(i, j, i, j - 1);
        }
        // right
        if(direction == 1){
            if(j == 8)  j = 7;
            switchTile(i, j, i, j + 1);
        }
        // up
        if(direction == 2){
            if(i == 0)  i = 1;
            switchTile(i, j, i - 1, j);
        }
        // down
        if(direction == 3){
            if(i == 5)  i = 4;
            switchTile(i, j, i + 1, j);
        }

        if(isSwitch)
            playerTurn = true;

    }

    /**
     * This method gets the mouse inputs.
     */
    private void getInput(){
        int i = game.getMouseManager().getPrev_i();
        int j = game.getMouseManager().getPrev_j();

        if(i == -1 || j == -1)
            return;

        // left
        if(j > 0 && game.getMouseManager().tiles[i][j-1]){
            switchTile(i, j, i, j - 1);
        }
        // right
        else if(j < 8 && game.getMouseManager().tiles[i][j+1]){
            switchTile(i, j, i, j + 1);
        }
        // up
        else if(i > 0 && game.getMouseManager().tiles[i-1][j]){
            switchTile(i, j, i - 1, j);
        }
        // down
        else if(i < 5 && game.getMouseManager().tiles[i+1][j]){
            switchTile(i, j, i + 1, j);
        }

        if(isSwitch)
            playerTurn = false;

    }

    /**
     * This method stores the information of the switched tiles.
     * @param i1 the row value of the first tile
     * @param j1 the column value of the first tile
     * @param i2 the row value of the second tile
     * @param j2 the column value of the second tile
     */
    private void updatePreviousMove(int i1, int j1, int i2, int j2){
        switched_i1 = i1;
        switched_j1 = j1;
        switched_i2 = i2;
        switched_j2 = j2;
    }

    /**
     * This method switches the selected tiles.
     * @param i1 the row value of the first tile
     * @param j1 the column value of the first tile
     * @param i2 the row value of the second tile
     * @param j2 the column value of the second tile
     */
    private void switchTile(int i1, int j1, int i2, int j2){
        //statusMessage += " switch the tiles: (" + i1 + ", " + j1 + ") and (" + i2 + ", " + j2 + ")";
        Color c1 = tiles[i1][j1].getColor();
        tiles[i1][j1] = SimpleTileFactory.createTile(game, tiles[i2][j2].getColor(), tiles[i1][j1].getX(), tiles[i1][j1].getY());
        tiles[i2][j2] = SimpleTileFactory.createTile(game, c1, tiles[i2][j2].getX(), tiles[i2][j2].getY());

        isSwitch = true;
        // the game slows down because
        // the player should see the changes in the game.
        game.setFps(5);
        updatePreviousMove(i1, j1, i2, j2);
        game.getMouseManager().setPrev_i(-1);
        game.getMouseManager().setPrev_j(-1);
    }

    /**
     * This method checks for matching tiles in the game.
     * @return true if the matching tiles are found. Otherwise, false.
     */
    private boolean checkMatchingTiles(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                // HORIZONTALLY [][][]
                if(j < 7) {
                    if (tiles[i][j].getColor() == tiles[i][j + 1].getColor() &&
                            tiles[i][j].getColor() == tiles[i][j + 2].getColor()) {
                        matchFound(0, i, j);
                        return true;
                    }
                }
                // VERTICALLY   []
                //              []
                //              []
                if(i < 4) {
                    if (tiles[i][j].getColor() == tiles[i + 1][j].getColor() &&
                            tiles[i][j].getColor() == tiles[i + 2][j].getColor()) {
                        matchFound(1, i, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * In this method, the matching tiles are disappeared.
     * @param newType type of the match
     * @param i The row value of the first of the matching tiles.
     * @param j The column value of the first of the matching tiles.
     */
    private void matchFound(int newType, int i, int j){
        // there are matching tiles
        isMatch = true;
        // the game slows down because
        // the player should see the changes in the game.
        game.setFps(5);
        // store the location (i, j) and type of the matching
        row = i;
        column = j;
        type = newType; // horizontal or vertical

        if(type == 0) { // horizontal
            // disappear the matching tiles
            tiles[i][j].setMatch(true);
            tiles[i][j + 1].setMatch(true);
            tiles[i][j + 2].setMatch(true);
            if(ownerLastMove != -1) {
                statusMessage = oneTileDamage(tiles[i][j], j) + ", "
                        + oneTileDamage(tiles[i][j + 1], j + 1) + ", "
                        + oneTileDamage(tiles[i][j + 2], j + 2);
            }
        }
        if(type == 1) { // vertical
            // disappear the matching tiles
            tiles[i][j].setMatch(true);
            tiles[i + 1][j].setMatch(true);
            tiles[i + 2][j].setMatch(true);
            if(ownerLastMove != -1) {
                statusMessage = oneTileDamage(tiles[i][j], j) + ", "
                    + oneTileDamage(tiles[i + 1][j], j) + ", "
                    + oneTileDamage(tiles[i + 2][j], j);
            }
        }

    }


    /**
     * This method calculates the damage for the taken tile
     * @param tile the tile that will damage
     * @param j the column value of the tile
     * @return the damage value and the attacked entity. It is used to statusMessage.
     */
    private String oneTileDamage(Tile tile, int j){
        double damage;
        if(j >= 0 && j <= 2){ // 0 1 2
            if(ownerLastMove == 0){ // attack E1
                damage = E1.damage() * XYZrule(tile.getColor(), E1.getColor());
                E1.reduceHealth(damage);
                return (int)damage + " to E1";
            }
            else if (ownerLastMove == 1){ // attack C1
                damage = C1.damage() * XYZrule(tile.getColor(), C1.getColor());
                C1.reduceHealth(damage);
                return (int)damage + " to C1";
            }
        }
        else if(j >= 3 && j <= 5){ // 3 4 5
            if(ownerLastMove == 0){ // attack E2
                damage = E2.damage() * XYZrule(tile.getColor(), E2.getColor());
                E2.reduceHealth(damage);
                return (int)damage + " to E2";
            }
            else if(ownerLastMove == 1){ // attack C2
                damage = C2.damage() * XYZrule(tile.getColor(), C2.getColor());
                C2.reduceHealth(damage);
                return (int)damage + " to C2";
            }
        }
        else if(j >= 6 && j <= 8){ // 6 7 8
            if(ownerLastMove == 0){ // attack E3
                damage = E3.damage() * XYZrule(tile.getColor(), E3.getColor());
                E3.reduceHealth(damage);
                return (int)damage + " to E3";
            }
            else if(ownerLastMove == 1){ // attack C3
                damage = C3.damage() * XYZrule(tile.getColor(), C3.getColor());
                C3.reduceHealth(damage);
                return (int)damage + " to C3";
            }
        }
        return "";
    }

    /**
     * This method determines the damage for the xyz rule.
     * @param tile the color of the tile that will damage
     * @param enemy the color of the entity that will take damage
     * @return the value of the damage
     */
    private double XYZrule(Color tile, Color enemy){
        if(tile == Color.red){
            if(enemy == Color.green)
                return 2;
            else if(enemy == Color.blue)
                return 0.5;
        }
        else if(tile == Color.blue){
            if(enemy == Color.red)
                return 2;
            else if(enemy == Color.green)
                return 0.5;
        }
        else if(tile == Color.green){
            if(enemy == Color.blue)
                return 2;
            else if(enemy == Color.red)
                return 0.5;
        }
        return 1;
    }

    /**
     * This method fills in the location the disappearing tiles.
     */
    private void fillEmptyTiles(){
        int i = row;
        int j = column;
        // HORIZONTALLY
        if(type == 0) {
            if(i < 5) {
                tiles[i][j] = SimpleTileFactory.createTile(game, tiles[i + 1][j].getColor(), tiles[i][j].getX(), tiles[i][j].getY());
                tiles[i][j + 1] = SimpleTileFactory.createTile(game, tiles[i + 1][j + 1].getColor(), tiles[i][j + 1].getX(), tiles[i][j + 1].getY());
                tiles[i][j + 2] = SimpleTileFactory.createTile(game, tiles[i + 1][j + 2].getColor(), tiles[i][j + 2].getX(), tiles[i][j + 2].getY());
                tiles[i + 1][j].setMatch(true);
                tiles[i + 1][j + 1].setMatch(true);
                tiles[i + 1][j + 2].setMatch(true);
            }
            if(i == 5) {
                Random r = new Random();
                int c = r.nextInt(3);
                tiles[i][j] = SimpleTileFactory.createTile(game, c, tiles[i][j].getX(), tiles[i][j].getY());
                c = r.nextInt(3);
                tiles[i][j + 1] = SimpleTileFactory.createTile(game, c, tiles[i][j + 1].getX(), tiles[i][j + 1].getY());
                c = r.nextInt(3);
                tiles[i][j + 2] = SimpleTileFactory.createTile(game, c, tiles[i][j + 2].getX(), tiles[i][j + 2].getY());
            }
        }
        // VERTICALLY
        else if(type == 1) {
            if(i <= 2) {
                tiles[i][j] = SimpleTileFactory.createTile(game, tiles[i + 3][j].getColor(), tiles[i][j].getX(), tiles[i][j].getY());
                tiles[i+3][j].setMatch(true);
            }
            else {
                Random r = new Random();
                int c = r.nextInt(3);
                tiles[i][j] = SimpleTileFactory.createTile(game, c, tiles[i][j].getX(), tiles[i][j].getY());
            }
        }
    }

}
