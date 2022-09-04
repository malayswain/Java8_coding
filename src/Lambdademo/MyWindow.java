package Lambdademo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

public class MyWindow {
    public static void main(String[] args) {
        //window: create object of Jframe
        JFrame jFrame = new JFrame("mywindow"); // to create a frame.
        jFrame.setSize(400,400);
        jFrame.setLayout(new FlowLayout());

//        ActionListener actionListener = (Action) -> {
//
//        };

        //create button and add jframe.

        JButton jButton = new JButton("click me");
        jButton.addActionListener((ActionEvent e) -> {
            System.out.println("button click");
            JOptionPane.showMessageDialog(null,"hey button click");
        });
        jFrame.add(jButton);

        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true); //to make it visible

    }
}
