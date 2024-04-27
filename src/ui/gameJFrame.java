package src.ui;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.util.Random;

public class gameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    int step = 0;
    JMenuItem replayItem = new JMenuItem("replay the game");
    JMenuItem reloginItem = new JMenuItem("relogin the game");
    JMenuItem closeItem = new JMenuItem("close the game");
    JMenuItem accountItem = new JMenuItem("info");


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
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();

        if (victory()) {
            JLabel winner = new JLabel("u win");
            winner.setBounds(275, 480, 100, 20);
            System.out.println("you win");
            this.getContentPane().add(winner);
        }
        System.out.println("step: " + step);
        JLabel stepCount = new JLabel("step: " + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\82728\\Documents\\GitHub\\Puzzle-Game\\Sucai\\" + num + ".png"));
                jLabel.setBounds(82 * j + 125, 82 * i + 120, 81, 81);
                jLabel.setBorder(new BevelBorder(0));
                this.getContentPane().add(jLabel);

            }
        }
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu funtionJMenu = new JMenu("funtion");
        JMenu aboutJMenu = new JMenu("about us");


        funtionJMenu.add(replayItem);
        funtionJMenu.add(reloginItem);
        funtionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

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
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon("C:\\Users\\82728\\Documents\\GitHub\\Puzzle-Game\\Sucai\\16.png"));
            all.setBounds(125, 120, 330, 330);
            this.getContentPane().add(all);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();

        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();

        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;

            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("replay the game");
            step = 0;
            initData();
            initImage();
        } else if (obj == reloginItem) {
            this.setVisible(false);
            new loginJFrame();
        } else if (obj == closeItem) {
            System.out.println("close the game");
            System.exit(0);
        } else if (obj == accountItem) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/thesorrymaker/Puzzle-Game"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
