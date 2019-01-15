package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class WorldContactListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        //called when 2 fixtures collide
        System.out.println("Begin Contact");

    }

    @Override
    public void endContact(Contact contact) {
        //called when the 2 fixtures connected gets split apart
        System.out.println("end Contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        //gives power to change the characteristics of fixture collision
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        //gives results of what happened because of collision like angles ext
    }

}
