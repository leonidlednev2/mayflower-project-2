import mayflower.*;
public class TitleScreen extends World {
    public TitleScreen() {
        setBackground("img/SF_bg.jpg");
        showText("Stick fighting game", 10, 30, Color.BLACK);
        showText("Press enter/return to start" , 10, 70, Color.BLACK);
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            GameWorld g = new GameWorld();
            Mayflower.setWorld(g);
        }
    }
}
