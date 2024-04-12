import mayflower.*;

public class Player extends Actor implements fighter {
    private int health;
    public Player() {
        health = 100; // Set initial health
    }
    
    @Override
    public void act()
    {
        // implement act
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
            GameOver();
        }
    }
    
    public void move(int x, int y) {
        setLocation(x,y);
    }
}

    


  
