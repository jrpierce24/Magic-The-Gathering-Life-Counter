package com.JRPierce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener{

    private int playerAmount;
    ArrayList<Player> playerList = new ArrayList<Player>();

    JButton twoP;
    JButton thrP;
    JButton fouP;
    Player one;
    Player two;
    Player three;
    Player four;



    MyFrame(){

        this.setSize(400, 150);
        this.setLayout(new FlowLayout());
        this.setTitle("How Many Players?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        twoP = new JButton("2");
        thrP = new JButton("3");
        fouP = new JButton("4");

        twoP.addActionListener(this);
        thrP.addActionListener(this);
        fouP.addActionListener(this);

        this.add(twoP);
        this.add(thrP);
        this.add(fouP);

        ImageIcon image = new ImageIcon("icon1.jpg"); // Creates an image icon
        this.setIconImage(image.getImage()); // Changes Icon Of frame to our image.
        this.getContentPane().setBackground(new Color(255,255,255)); // changes color of background


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == twoP){
            playerAmount = 2;
            this.drawGame();
        }
        else if(e.getSource() == thrP){
            playerAmount = 3;
            this.drawGame();
        }
        else if(e.getSource() == fouP){
            playerAmount = 4;
            this.drawGame();
        }


    }


    public void drawGame() {

        one = new Player();
        two = new Player();
        three = new Player();
        four = new Player();


        this.getContentPane().removeAll();

        int[] rowCol = XYGame();

        this.setLayout(new GridLayout(rowCol[1], rowCol[0], 10, 10));

        JPanel p1;
        JPanel p2;
        JPanel p3;
        JPanel p4;

        switch (playerAmount) {
            case 2:
                this.setSize(800, 400);

                this.setTitle("Dual for Two");

                p1 = new JPanel();
                p2 = new JPanel();

                one.panel = p1;
                two.panel = p2;

                this.add(p1);
                this.add(p2);

                one.makePlayer(p1);
                two.makePlayer(p2);

                break;

            case 3:
                this.setSize(1200, 400);
                this.setTitle("How Bout a Gangbang!");

                p1 = new JPanel();
                p2 = new JPanel();
                p3 = new JPanel();

                one.panel = p1;
                two.panel = p2;
                three.panel = p3;

                this.add(p1);
                this.add(p2);
                this.add(p3);

                one.makePlayer(p1);
                two.makePlayer(p2);
                three.makePlayer(p3);


                break;

            case 4:
                this.setSize(800, 800);
                this.setTitle("Is there a single player option?");

                p1 = new JPanel();
                p2 = new JPanel();
                p3 = new JPanel();
                p4 = new JPanel();

                one.panel = p1;
                two.panel = p2;
                three.panel = p3;
                four.panel = p4;

                this.add(p1);
                this.add(p2);
                this.add(p3);
                this.add(p4);

                one.makePlayer(p1);
                two.makePlayer(p2);
                three.makePlayer(p3);
                four.makePlayer(p4);

                break;
        }
    }

        //helper

    public int[] XYGame(){
        int[] XY = new int[2];

        if(playerAmount <= 3){ }else{
            XY[0] = 2;
            XY[1] = 2;
        }
        if(playerAmount == 2){
            XY[0] = 2;
            XY[1] = 1;
        }else if(playerAmount == 3){
            XY[0] = 3;
            XY[1] = 1;
        }
        return XY;
    }

}
