import mayflower.*;

public class Attack extends Actor {
    private static final int SPEED = 5; // Adjust as needed
    
    public Attack() {
        setImage("path_to_attack_image.png"); // Set the image for the attack
    }

    public void act() {
        // Move the attack horizontally
        setLocation(getX() + SPEED, getY());

        // Check if the attack is off-screen and remove it if it is
        if (getX() > getWorld().getWidth()) {
            getWorld().removeObject(this);
        }
    }
}
