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
        setImage("img/stickman1a.png");
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

        if (Mayflower.isKeyDown(Keyboard.KEY_NUMPAD0)) {
            try {
                attack();
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }
        }

        if (isMovingUp && getY() > 0) {
            setLocation(getX(), getY() - SPEED);
        }
        if (isMovingLeft && getX() > getWorld().getWidth() / 2) {
            setLocation(getX() - SPEED, getY());
        }
        if (isMovingRight && getX() + getWidth() < getWorld().getWidth()) {
            setLocation(getX() + SPEED, getY());
        }
        if (isMovingDown && getY() + getHeight() < getWorld().getHeight()) {
            setLocation(getX(), getY() + SPEED);
        }

        if (getImage().equals(new MayflowerImage("img/stickman1b.png"))) {
            setImage("img/stickman1a.png");
        } else {
            setImage("img/stickman1b.png");
        }

    }

    public void gameOver() {
        Mayflower.setWorld(new GameOver("Player 2"));
    }

    public void attack() {
        World world = getWorld();
        Attack attack = new Attack(1);
        int x = getX() - 10;
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
