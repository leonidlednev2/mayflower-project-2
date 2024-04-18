import mayflower.*;

public class GameWorld extends World {
    private Actor f1;
    private Actor f2;
    
    public GameWorld() {
        setBackground("img/SF_bg.jpg");
        f1 = new Player();
        f2 = new Enemy();
        addObject(f1, 100, 200);
        
    }
    
    public void act() {
        
    }
}