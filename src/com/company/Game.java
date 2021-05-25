package com.company;

import java.awt.*;

public class Game {
    private Canvas canvas;
    private Listener listener;
    private Player player;

    public Game(Canvas canvas){
        this.canvas = canvas;
        listener = new Listener(this.canvas);
    }

    public void update(){

    }

    public void draw(Graphics2D g){

    }
}
