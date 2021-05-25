package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test");
        Main main = new Main();
        main.start();
    }
    public Main(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void start(){
        System.out.println("Start main");
    }
}
