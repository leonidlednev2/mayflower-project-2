import mayflower.*;

public class Attack extends Actor {
    private static final int SPEED = 5; // Adjust as needed
    private int who; // 0 is Player, 1 is Enemy
    private static final int DAMAGE = 10;
    public Attack(int who) {
        setImage("path_to_attack_image.png"); // Set the image for the attack
        this.who = who;
    }

    public void act() {
        // Move the attack horizontally
        setLocation(getX() + SPEED, getY());

        // Check if the attack is off-screen and remove it if it is
        if (getX() > getWorld().getWidth()) {
            getWorld().removeObject(this);
        }

        // Check if the attack is touching the enemy (if launched by player)
        if (isTouching(Enemy.class) && who == 0) {
            Enemy e = getOneIntersectingObject(Enemy.class);
            e.takeDamage(DAMAGE); // CHANGEME
        }

        // inverse of the above
        if (isTouching(Player.class) && who == 1) {
            Player p = getOneIntersectingObject(Player.class);
            p.takeDamage(DAMAGE);
        }
    }
}
