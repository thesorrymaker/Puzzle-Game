package src.ui;

import javax.swing.*;

public class gameJFrame extends JFrame {
    public gameJFrame() {
        initJFrame();

        initJMenuBar();

        initImage();

        this.setVisible(true);
    }

    private void initImage() {
        int number = 1;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\82728\\Documents\\GitHub\\Puzzle-Game\\Sucai\\" + number + ".png"));
                jLabel.setBounds(81 * i, 81 * j, 81, 81);
                this.getContentPane().add(jLabel);
                number++;
            }
        }
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
