import mayflower.*;

/**
 * The `Player` class
 * 
 * This class is used to control the player character with the arrow keys
 */
public class Player extends Actor implements Fighter {
    private int health;
    private final int SPEED = 5; //CHANGEME
    private boolean isMovingUp;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean isMovingDown;

    public Player() {
        health = 100;
        setImage("img/stickman1.png");
        isMovingUp = false;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingDown = false;
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_UP)) {
            isMovingUp = true;
        } else {
            isMovingUp = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)) {
            isMovingLeft = true;
        } else {
            isMovingLeft = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) {
            isMovingRight = true;
        } else {
            isMovingRight = false;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            isMovingDown = true;
        } else {
            isMovingDown = false;
        }

        if (isMovingUp) {
            setLocation(getX(), getY() - SPEED);
        }
        if (isMovingLeft) {
            setLocation(getX() - SPEED, getY());
        }
        if (isMovingRight) {
            setLocation(getX() + SPEED, getY());
        }
        if (isMovingDown) {
            setLocation(getX(), getY() + SPEED);
        }

        if (getImage().equals(new MayflowerImage("img/stickman1b.png"))) {
            setImage("img/stickman1a.png");
        } else {
            setImage("img/stickman1b.png");
        }

    }

    public void gameOver() {
        Mayflower.setWorld(new GameOver());
    }

    public void attack() {
        World world = getWorld();
        Attack attack = new Attack(0);

        int x = getX() + getImage().getWidth() + 10;
        int y = getY();

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
