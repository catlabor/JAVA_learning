
package com.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJframe extends JFrame implements KeyListener, ActionListener {
    int[][] twoArr=new int[4][4];
    int x=0;
    int y=0;
    String path="D:\\java\\Learn\\practice\\small_step\\image\\animal\\animal2\\";
    int [][] right=new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    int step=0;

    JMenuItem jMenuItemReplay=new JMenuItem("replay/再開");
    JMenuItem jMenuItemReLogin=new JMenuItem("reLogin/再度登録");
    JMenuItem jMenuItemOut=new JMenuItem("quit/退出");
    JMenuItem jMenuItemContact=new JMenuItem("contact/連絡");

    public gameJframe(){
        gameAppearanceDefault();

        gameJframeDefault();

        gamePhotoRandom();  //initialize photos

        gamePhotoInitialize(); //load photo after incident of each response for keylistener

        this.setVisible(true);
    }

    private void gamePhotoRandom() {
        int [] arr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random rd=new Random();
        for (int i = 0; i < arr.length; i++) {     //obtain a random initial puzzle
            int index=rd.nextInt(arr.length);
            int num=arr[i];
            arr[i]=arr[index];
            arr[index]=num;
        }
        for (int i = 0; i < arr.length; i++) {
            twoArr[i/4][i%4]=arr[i];
        }
    }

    private void gamePhotoInitialize() {

        this.getContentPane().removeAll();  //remove all previous photos

        if(decision()){
            JLabel victory=new JLabel(new ImageIcon("D:\\java\\Learn\\practice\\small_step\\image\\win.png"));
            victory.setBounds(203,283,197,73);
            this.getContentPane().add(victory);
        }

        JLabel numStep=new JLabel("step/ステップ"+step);
        numStep.setBounds(50,30,100,20);
        this.getContentPane().add(numStep);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int random_number=twoArr[i][j];
                if(random_number==0){
                    x=i;
                    y=j;
                }else{
                    ImageIcon ico=new ImageIcon(path+random_number+".jpg");
                    JLabel label=new JLabel(ico);
                    label.setBounds(105*j+83,105*i+134,105,105);
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
                }

            }
        }

        ImageIcon bg=new ImageIcon("small_step\\image\\background.png");
        JLabel background=new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();

    }

    public void gameJframeDefault() {
        this.setSize(603,680);
        this.setTitle("puzzle ver1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(this);   //wait for command from keyboard

        this.setLayout(null);
    }

    private void gameAppearanceDefault() {
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenuFunction=new JMenu("function/機能");
        JMenu jMenuAbout=new JMenu("about us/お間に合わせ");


        jMenuFunction.add(jMenuItemReplay);
        jMenuFunction.add(jMenuItemReLogin);
        jMenuFunction.add(jMenuItemOut);
        jMenuAbout.add(jMenuItemContact);

        jMenuItemReplay.addActionListener(this);
        jMenuItemReLogin.addActionListener(this);
        jMenuItemOut.addActionListener(this);
        jMenuItemContact.addActionListener(this);

        jMenuBar.add(jMenuFunction);
        jMenuBar.add(jMenuAbout);

        this.setJMenuBar(jMenuBar);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int num=e.getKeyCode();
        if(num==65){
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            
            JLabel bg=new JLabel(new ImageIcon("D:\\java\\Learn\\practice\\small_step\\image\\background.png"));
            bg.setBounds(40,40,508,560);
            this.getContentPane().add(bg);
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(decision()){
            return;
        }

        int num=e.getKeyCode();
        if(num==37){
            if(y==3){
                return;
            }
            twoArr[x][y]=twoArr[x][y+1];
            twoArr[x][y+1]=0;
            step++;
        } else if (num==38) {
            if(x==3){
                return;
            }
            twoArr[x][y]=twoArr[x+1][y];
            twoArr[x+1][y]=0;
            step++;
        }else if (num==39) {
            if(y==0){
                return;
            }
            twoArr[x][y]=twoArr[x][y-1];
            twoArr[x][y-1]=0;
            step++;
        }else if (num==40) {
            if(x==0){
                return;
            }
            twoArr[x][y]=twoArr[x-1][y];
            twoArr[x-1][y]=0;
            step++;
        } else if (num==80) {
            twoArr=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
        }
        gamePhotoInitialize();
    }

    public boolean decision(){
        for (int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr[i].length; j++) {
                if(twoArr[i][j]!=right[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object event=e.getSource();
        if(event==jMenuItemReplay){
            step=0;
            gamePhotoRandom();
            gamePhotoInitialize();
        } else if (event==jMenuItemReLogin) {
            this.setVisible(false);
            new loginJframe();
        } else if (event==jMenuItemOut) {
            System.exit(0);
        } else if (event==jMenuItemContact) {
            JDialog dialog=new JDialog();
            JLabel photo=new JLabel(new ImageIcon("D:\\java\\Learn\\practice\\small_step\\3683.jpg"));
            photo.setBounds(0,0,1200,720);
            dialog.getContentPane().add(photo);
            dialog.setSize(1300,1000);
            dialog.setAlwaysOnTop(true);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }
}
