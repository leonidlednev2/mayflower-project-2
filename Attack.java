import mayflower.*;
/**
 * The Attack class
 * 
 * This class is used to configure how the attack projectile works in-game
 */
public class Attack extends Actor {
    private static final int SPEED = 5; // Adjust as needed
    private int who; // 0 is Enemy, 1 is Player
    private static final int DAMAGE = 10;

    public Attack(int who) {
        this.who = who;
        if (who == 0) {
            setImage("img/attack1.png");
        } else {
            MayflowerImage img = new MayflowerImage("img/attack1.png");
            img.mirrorHorizontally();
            setImage(img);
        }
    }

    public void act() {
        // Move the attack horizontally
        if (who == 0) {
            setLocation(getX() + SPEED, getY());
        } else {
            setLocation(getX() - SPEED, getY());
        }

        // Check if the attack is off-screen and remove it if it is
        if (getX() > getWorld().getWidth() || getX() < 0 - getWidth()) {
            getWorld().removeObject(this);
        }

        // Check if the attack is touching the enemy (if launched by player),
        // deal damage if it is, and remove the attack
        if (isTouching(Player.class) && who == 1) {

        }
        else if (isTouching(Player.class) && who == 0) {
            Player p = getOneIntersectingObject(Player.class);
            p.takeDamage(DAMAGE);
            getWorld().removeObject(this);
        } else if (isTouching(Enemy.class) && who == 1) {
            Enemy e = getOneIntersectingObject(Enemy.class);
            e.takeDamage(DAMAGE);
            getWorld().removeObject(this);
        }
    }
}
