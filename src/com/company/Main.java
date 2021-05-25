package com.company;

import javax.swing.*;

public class Main {

    private JFrame frame;

    public static void main(String[] args) {
        System.out.println("Test");
        Main main = new Main();
        main.start();
    }
    public Main(){
        createGUI();
    }
    private void start(){
        frame.setVisible(true);
    }

    private void createGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
    }
}
