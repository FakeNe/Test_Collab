package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    public static Canvas canvas;
    private Listener listener;
    private Player player;
    private ArrayList<Wall> walls = new ArrayList<>();
    private int score = 0;

    public Game(Canvas canvas){
        this.canvas = canvas;
        listener = new Listener(this.canvas);
        player = new Player(listener);
        init();
    }

    private void init() {
        for(int i = 0; i < 10; i++){
            double r = Math.random();
            if(r > 0.5) {
                walls.add(new Wall(canvas.getWidth() + (Math.random() * canvas.getWidth()), 0, 100*Math.random(), Math.random()*100));
            }else{
                walls.add(new Wall(canvas.getWidth() + (Math.random() * canvas.getWidth()), Math.random()*10+canvas.getHeight()/2, 100*Math.random(), canvas.getHeight()));
            }
        }
    }

    public void update(){
        for(Wall wall : walls){
            wall.update();
            if(wall.x < 0){
                score++;
            }
            if(wall.collision(player)){
                score = 0;
                walls.forEach(wall1 -> {
                    wall1.toDestroy = true;
                });
            }
        }
        player.update();
        Main.label.setText("Score: " + score);
    }

    public void draw(Graphics2D g){
        g.setColor(new Color(51,51,51,20));
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        for(Wall wall : walls){
            wall.draw(g);
        }
        player.draw(g);
        for(Wall wall : walls){
            if(wall.toDestroy){
                double r = Math.random();
                wall.x = canvas.getWidth() + (Math.random() * canvas.getWidth());
                wall.n = (int) (Math.random()*wall.colors.length);
                if(r > 0.5) {
                    wall.y = 0;
                    wall.width = 100*Math.random();
                    wall.height = Math.random()*100;
                }else{
                    wall.y = Math.random()*10+canvas.getHeight()/2;
                    wall.width = 100*Math.random();
                    wall.height = canvas.getHeight();
                }
                wall.toDestroy = false;
            }
        }
    }
}
