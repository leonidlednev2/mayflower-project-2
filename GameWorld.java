import mayflower.*;

public class GameWorld extends World {
    private Actor f1;
    private Actor f2;
    

    public GameWorld() {
        f1 = new Player();
        f2 = new Enemy();
        setBackground("img/SF_bg.jpg");
    }

    public void act() {
        
    }
}