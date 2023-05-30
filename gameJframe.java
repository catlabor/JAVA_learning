
package com.small.small;

import javax.swing.*;
import java.util.Random;

public class gameJframe extends JFrame {
    int[][] twoArr=new int[4][4];
        public gameJframe(){
            gameAppearanceDefault();

            gameJframeDefault();

            gamePhotoRandom();

            gamePhotoInitialize();

            this.setVisible(true);
        }

        private void gamePhotoRandom() {
            int [] arr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            Random rd=new Random();
            for (int i = 0; i < arr.length; i++) {
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
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int random_number=twoArr[i][j];
                    ImageIcon ico=new ImageIcon("D:\\Java\\practice\\basic_code\\small_game\\image\\animal\\animal8\\"+random_number+".jpg");
                    JLabel label=new JLabel(ico);
                    label.setBounds(105*i,105*j,105,105);
                    this.add(label);
                }
            }

        }

        public void gameJframeDefault() {
            this.setSize(603,680);
            this.setTitle("puzzle ver1.0");
            this.setAlwaysOnTop(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            this.setLayout(null);
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
