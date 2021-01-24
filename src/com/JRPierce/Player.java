package com.JRPierce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Player extends MyFrame{

    private int health = 20;
    JPanel panel;
    JButton up;
    JLabel life;
    JButton down;

    Player(){
        health = 20;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == down){
            decHealth();
            life.setText(String.valueOf(health));
        }else if(e.getSource() == up){
            incHealth();
            life.setText(String.valueOf(health));
        }
    }


    public void incHealth(){
        health++;
    }

    public void decHealth(){
        health--;
    }

    public int getHealth(){
        return health;
    }

    public void makePlayer(JPanel panel){
        panel.setLayout(new GridLayout(1,3));

        down = new JButton();
        down.setContentAreaFilled(false);
        down.addActionListener(this);
        down.setText("-");
        down.setFont(new Font("Comic Sans", Font.BOLD,80));

        life = new JLabel();
        life.setText(String.valueOf(health));
        life.setFont(new Font("Comic Sans", Font.BOLD,80));

        up = new JButton();
        up.setContentAreaFilled(false);
        up.addActionListener(this);
        up.setText("+");
        up.setFont(new Font("Comic Sans", Font.BOLD,80));

        panel.add(down);
        panel.add(life);
        panel.add(up);

    }

}
