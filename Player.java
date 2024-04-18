import mayflower.*;

public class Player extends Actor implements Fighter {
    private int health;
    private int SPEED = 5; 
    private boolean isMovingUp;
    private int walkCounter;
    private boolean isMovingLeft;
    private boolean isMovingRight;
               
    public Player() {
        health = 100;
        setImage("stickman1.png");
        isMovingUp = false;
        isMovingLeft = false;
        isMovingRight = false;
        walkCounter = 0;
    }

    public void onKeyDown(int keyCode) {
        // Handle key press events
        if (keyCode == Keyboard.KEY_UP) {
            isMovingUp = true;
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
      
        if (keyCode == Keyboard.KEY_LEFT) {
            isMovingLeft = false;
        }
        if (keyCode == Keyboard.KEY_RIGHT) {
            isMovingRight = false;
        }
    }   

    @Override
    public void act()
    {
        if (isMovingUp) {
            setLocation(getX(), getY() - SPEED);
        }
        if (isMovingLeft) {
            setLocation(getX() - SPEED, getY());
        }
        if (isMovingRight) {
            setLocation(getX() + SPEED, getY());
        }
        walkCounter++;
        
        if(getImage().equals("stickman1.png")){
            setImage("stickman walk.png");
            
        }
        else{
         setImage("stickman1.png");   
        }
        
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

    


  


