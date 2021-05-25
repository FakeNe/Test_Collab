package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main {

    private JFrame frame;
    private Canvas canvas;
    public static JLabel label;
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
        frame.getContentPane().setBackground(new Color(51,51,51));
        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
        label = new JLabel("Score: 0");
        label.setForeground(new Color(200,200,200));
        label.setFont(new Font("Arial", Font.PLAIN,15));
        label.setBounds(frame.getWidth()/2-40,2,80,15);
        label.setBackground(new Color(0,0,0,0));
        frame.add(label);
        canvas = new Canvas();
        canvas.setBackground(new Color(51,51,51));
        canvas.setBounds(0,10,frame.getWidth(), frame.getHeight()-20);
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
