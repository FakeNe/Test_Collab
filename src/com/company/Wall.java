package com.company;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall {

    public double x, y, width, height, speed = 1;
    public boolean toDestroy = false;
    Color[] colors = new Color[]{new Color(100,30,200),new Color(122, 21, 132),new Color(2, 255, 236), new Color(100,30,200), new Color(75, 35, 132)};
    int n = (int) (Math.random()*colors.length);
    public Wall(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void update(){
        x -= speed;
        if(x + width < 0){
            toDestroy = true;
        }
    }
    public void draw(Graphics2D g){
        g.setColor(colors[n]);
        Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,width,height);
//        g.fillRect(x,y,width,height);
        g.fill(rectangle2D);
    }
    public boolean collision(Player player){
        Rectangle r = new Rectangle(player.x, player.y, player.width, player.height);
        return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
    }
}
