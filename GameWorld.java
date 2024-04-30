import mayflower.*;

public class GameWorld extends World {
    private Player p;
    private Enemy e;

    public GameWorld() {
        p = new Player();
        e = new Enemy();
        setBackground("img/SF_bg.jpg");

        addObject(p, 300, 200);
        addObject(e, 100, 200);
    }

    public void act() {
        
    }
}