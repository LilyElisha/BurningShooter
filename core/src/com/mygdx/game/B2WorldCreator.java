package com.mygdx.game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Sprites.Block;

public class B2WorldCreator {
    public B2WorldCreator(PlayScreen screen) {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;


        //ground layer
        for (MapObject object : map.getLayers().get(/*if u go to Tiled 3rd party app and u go to layers count up from the bottom layer but start at 0 so 0 is background 3 is blocks ext*/2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / main.PPM, (rect.getY() + rect.getHeight() / 2) / main.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / main.PPM, rect.getHeight() / 2 / main.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //blocks layer
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Block(screen, rect);
        }
    }

}
