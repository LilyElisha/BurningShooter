package worlds;

import com.mygdx.game.WorldObjects;
import com.mygdx.game.WorldSetup;

public class World_1x1 {
    public void go() {
        //die.
        //world file here
        WorldSetup.WorldTexture = "sunny ground.png";
    }

    public void objs() {
    	WorldObjects.Square(20, 20, 20, 20);
    }

}
