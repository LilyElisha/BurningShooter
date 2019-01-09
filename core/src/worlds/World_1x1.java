package worlds;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.WorldObjects;
import com.mygdx.game.WorldSetup;

@SuppressWarnings("unused")
public class World_1x1 {
    public void go() {
        //die.
        //world file here
        WorldSetup.WorldTexture = "sunny ground.png";
    }

    
    public void objs() {
    	WorldObjects.Square(200, 200, 200, 200);
    }

}
