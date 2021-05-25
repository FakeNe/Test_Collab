package com.company;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player {
    public int x = 50, y = Game.canvas.getHeight()/2-13, width = 25, height = 25, gravity = 2;
    private Listener listener;
    public Player(Listener listener){
        this.listener = listener;
    }
    public void update(){
        if(listener.space.pressed){
            y -= 5;
//            gravity = -gravity;
        }
        y += gravity;
        if(y <= 0){
            y = 1;
        }
        if(y + height >= Game.canvas.getHeight()){
            y = Game.canvas.getHeight()-height;
        }
    }
    public void draw(Graphics2D g){
        g.setColor(new Color(200,30,100));
        g.fillRect(x,y,width,height);
    }
}
