package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main {

    private JFrame frame;
    private Canvas canvas;
    private Game game;

    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        createGUI();
        init();
        Thread thread = new Thread(() -> {
            long now, before = System.nanoTime();
            long time = System.currentTimeMillis();
            long ns = 1_000_000_000/60;
            int fps = 0;
            while (true){
                now = System.nanoTime();
                if((now - before) > ns){
                    before = now;
                    update();
                    draw();
                    fps++;
                }
                if((System.currentTimeMillis() - time) > 1000){
                    time = System.currentTimeMillis();
                    frame.setTitle("Fps: " + fps);
                    fps = 0;
                }

            }
        });
        thread.start();
    }
    private void createGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        canvas = new Canvas();
        canvas.setBackground(new Color(51,51,51));
        frame.add(canvas);
        frame.setVisible(true);
        canvas.createBufferStrategy(3);
        canvas.requestFocus();
    }
    private void init(){
        game = new Game(canvas);
    }
    private void update(){
        game.update();
    }
    private void draw(){
        BufferStrategy bf = canvas.getBufferStrategy();
        Graphics2D g = (Graphics2D) bf.getDrawGraphics();

        game.draw(g);

        g.dispose();
        bf.show();
    }
}
