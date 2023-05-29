package com.ui;

import javax.swing.*;

public class gameJframe extends JFrame {
    public gameJframe(){
        gameAppearanceDefault();

        gameJframeDefault();


        this.setVisible(true);
    }
    public void gameJframeDefault() {
        this.setSize(603,680);
        this.setTitle("puzzle ver1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void gameAppearanceDefault() {
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenuFunction=new JMenu("function/機能");
        JMenu jMenuAbout=new JMenu("about us/お間に合わせ");
        JMenuItem jMenuItemReplay=new JMenuItem("replay/再開");
        JMenuItem jMenuItemReLogin=new JMenuItem("reLogin/再度登録");
        JMenuItem jMenuItemOut=new JMenuItem("quit/退出");
        JMenuItem jMenuItemContact=new JMenuItem("contact/連絡");

        jMenuFunction.add(jMenuItemReplay);
        jMenuFunction.add(jMenuItemReLogin);
        jMenuFunction.add(jMenuItemOut);
        jMenuAbout.add(jMenuItemContact);

        jMenuBar.add(jMenuFunction);
        jMenuBar.add(jMenuAbout);

        this.setJMenuBar(jMenuBar);
    }


}
