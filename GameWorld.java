import mayflower.*;

public class GameWorld extends World {
    private Player p;
    private Enemy e;

    public GameWorld() {
        p = new Player();
        e = new Enemy();
        setBackground("img/SF_bg.jpg");

        addObject(p, 100, 100);
        addObject(e, 100, 700);
    }

    public void act() {
        
    }
}