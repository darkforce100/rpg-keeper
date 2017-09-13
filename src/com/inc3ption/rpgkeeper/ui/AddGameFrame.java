package com.inc3ption.rpgkeeper.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by telgetr on 12/23/15.
 */
public class AddGameFrame extends JFrame {
    public AddGameFrame(){
        System.out.println("Starting details frame...");
        this.setTitle("Add New Game");
        JTabbedPane addGamePane = new JTabbedPane();
        addGamePane.addTab("RPG Maker", new RPGMakerDetailsPanel(false, this));
        addGamePane.addTab("RAGS", new RAGSDetailsPanel(false, this));
        addGamePane.addTab(".EXE", new EXEDetailsPanel(false, this));
        this.setContentPane(addGamePane);
        this.setSize(new Dimension(500, 500));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.getContentPane().setVisible(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}
