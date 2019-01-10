package worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.game.WorldObjects;
import com.mygdx.game.WorldSetup;


public class World_1x1 {
    public void go() {

        FileHandle file = Gdx.files.internal("World_1x1.world");
        String st = "";
        try {
            st = file.readString();
            System.out.println(st);
        } catch (Exception e) {
            System.out.println("No world found");
        }

        WorldSetup.WorldTexture = st;
    }


    public void objs() {
        WorldObjects.Square(200, 200, 200, 200);
    }

}
