import mayflower.*;
/**
 * The `Enemy` class
 * 
 * This class is used to control the other character with the WASD keys.
 * It is almost an exact copy of the `Player` class
 */
public class Enemy extends Actor implements Fighter {
    private int health;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private static final int SPEED = 5; 
    public Enemy() {
        health = 100; // Set initial health
        setImage("img/stickman1a.png");
    }

    public void act(){
        if (Mayflower.isKeyDown(Keyboard.KEY_W)) {
            isMovingUp = true;
        } else {
            isMovingUp = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_A)) {
            isMovingLeft = true;
        } else {
            isMovingLeft = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_D)) {
            isMovingRight = true;
        } else {
            isMovingRight = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_S)) {
            isMovingDown = true;
        } else {
            isMovingDown = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)) {
            attack();
        }
        
        if (isMovingUp && getY() > 0) {
            setLocation(getX(), getY() - SPEED);
        }
        if (isMovingRight && getX() + getWidth() < getWorld().getWidth() / 2) {
            setLocation(getX() + SPEED, getY());
        }
        if (isMovingLeft && getX() > 0) {
            setLocation(getX() - SPEED, getY());
        }
        if (isMovingDown && getY() + getHeight() < getWorld().getHeight()) {
            setLocation(getX(), getY() + SPEED);
        }
    }

    public void gameOver() {
        Mayflower.setWorld(new GameOver("Player 2"));
    }

    public void attack() {
        World world = getWorld();
        Attack attack = new Attack(0);
        int x = getX() + getImage().getWidth() + 20;
        int y = getY() + getHeight() / 2;
        world.addObject(attack, x, y);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            getWorld().removeObject(this);
            gameOver();
        }
    }

    public void move(int x, int y) {
        setLocation(x,y);
    }
}
