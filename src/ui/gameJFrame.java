package src.ui;

import javax.swing.*;
import java.util.Random;

public class gameJFrame extends JFrame {
    int[][] data = new int[4][4];

    public gameJFrame() {
        initData();

        initJFrame();

        initJMenuBar();

        initImage();
        
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
        System.out.println(data[2][1]);
    }

    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\82728\\Documents\\GitHub\\Puzzle-Game\\Sucai\\" + num + ".png"));
                jLabel.setBounds(82 * j, 82 * i, 81, 81);
                this.getContentPane().add(jLabel);
                //System.out.println(i);
            }
        }
        System.out.println(data[2][1]);
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu funtionJMenu = new JMenu("funtion");
        JMenu aboutJMenu = new JMenu("about us");

        JMenuItem replayItem = new JMenuItem("replay the game");
        JMenuItem reloginItem = new JMenuItem("relogin the game");
        JMenuItem closeItem = new JMenuItem("close the game");
        JMenuItem accountItem = new JMenuItem("info");


        funtionJMenu.add(replayItem);
        funtionJMenu.add(reloginItem);
        funtionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(funtionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("Puzzle Game v1.0");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
    }
}
