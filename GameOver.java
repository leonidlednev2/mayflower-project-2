import mayflower.*;
/**
 * The GameOver class
 * 
 * It displays when one side's health reaches 0
 */
public class GameOver extends World {
    /**
     * Constructor
     * Sets background to `gameOver.png`
     */
    public GameOver(String winner) {
        showText("Game over!", 10, 50, Color.BLACK);
        showText(winner + " wins", 10, 90, Color.BLACK);
    }

    /**
     * The act() method should be blank?
     */
    public void act() {
        
    }
}
