import mayflower.*;

public class Enemy extends Actor implements Fighter {
    private int health;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private static final int SPEED = 5; 
    public Enemy() {
        health = 100; // Set initial health
    }
    
    public void onKeyDown(int keyCode) {
        // Handle key press events
        if (keyCode == Keyboard.KEY_UP) {
            isMovingUp = true;
        }
        if (keyCode == Keyboard.KEY_DOWN) {
            isMovingDown = true;
        }
        if (keyCode == Keyboard.KEY_LEFT) {
            isMovingLeft = true;
        }
        if (keyCode == Keyboard.KEY_RIGHT) {
            isMovingRight = true;
        }
    }
     public void onKeyUp(int keyCode) {
        // Handle key release events
        if (keyCode == Keyboard.KEY_UP) {
            isMovingUp = false;
        }
        if (keyCode == Keyboard.KEY_DOWN) {
            isMovingDown = false;
        }
        if (keyCode == Keyboard.KEY_LEFT) {
            isMovingLeft = false;
        }
        if (keyCode == Keyboard.KEY_RIGHT) {
            isMovingRight = false;
        }
    }


    public void act()
    {
        if (isMovingUp) {
            setLocation(getX(), getY() - SPEED);
        }
        if (isMovingDown) {
            setLocation(getX(), getY() + SPEED);
        }
        if (isMovingLeft) {
            setLocation(getX() - SPEED, getY());
        }
        if (isMovingRight) {
            setLocation(getX() + SPEED, getY());
        }
    }
    public void gameOver() {
        Mayflower.setWorld(new GameOver());
    }

    public void attack() {
        World world = getWorld();
        Attack attack = new Attack(1);
        
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