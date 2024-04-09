import mayflower.*;
public class TitleScreen extends World
{

    public TitleScreen()
    {
        // setBackground("img/BG/BG.png");
        showText("Lorem ipsum",10,30,Color.BLACK);
        showText("Lorem ipsum" , 10, 70, Color.BLACK);
        //showText("You can also collect hearts to increase your lives. If you touch a spike you lose a life and reset locations. If you touch a cloud or fall of the screen you die" , 10 , 70, Color.BLACK);

    }

    public void act()
    {
        /*if (Mayflower.isKeyDown(Keyboard.KEY_UP))
        {
            GameWorld g = new GameWorld();
            Mayflower.setWorld(new GameWorld());

        }*/
    }

}
