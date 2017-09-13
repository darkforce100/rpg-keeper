package com.inc3ption.rpgkeeper.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trenton on 11/26/2015.
 */
public class KeeperFrame extends JFrame{
    public KeeperFrame(){
        this.setTitle("RPG Keeper");
        final JPanel mainPanel = new JPanel(new BorderLayout());
        JToolBar toolbar = new JToolBar(SwingConstants.HORIZONTAL);
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton fileButton = new JButton("File");
        JPopupMenu filePopupMenu = new JPopupMenu();
        JMenuItem addGame = new JMenuItem("Add Game");
        addGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGameFrame();
            }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        filePopupMenu.add(addGame);
        filePopupMenu.add(exit);
        DropDownButton fileDropDownButton = new DropDownButton(fileButton, filePopupMenu);
        JButton driversButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(RPGMakerDetailsPanel.class.getResource("/com/inc3ption/rpgkeeper/ui/images/application_xp_terminal.png"))));
        toolbar.add(fileDropDownButton);
        toolbar.add(driversButton);
        //toolbar.setRollover(true);

        this.setContentPane(mainPanel);
        mainPanel.add(toolbar, BorderLayout.NORTH);
        //mainPanel.add(new LibraryListPanel(), BorderLayout.CENTER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600, 300));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);


        mainPanel.setVisible(true);
        this.setVisible(true);
    }
}
