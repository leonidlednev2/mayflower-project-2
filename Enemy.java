import mayflower.*;

public class Enemy extends Actor implements Fighter {
    private int health;
    public Enemy() {
        health = 100; // Set initial health
    }
    
    @Override
    public void act()
    {
        // implement act
    }
    public void gameOver()
    {
    }

    public void attack() {
        World world = getWorld();
        Attack attack = new Attack();
        
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