package com.inc3ption.rpgkeeper.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Trenton on 11/25/2015.
 */
public class LoaderFrame extends JFrame {
    private JProgressBar prog;
    public LoaderFrame(String title, String text, int maxLoad, int initLoad, int defaultCloseOperation){
        this.setTitle(title);
        JPanel content = new JPanel(new BorderLayout());
        this.setContentPane(content);
        JLabel prompt = new JLabel(text, SwingConstants.CENTER);
        this.add(prompt, BorderLayout.NORTH);
        prog = new JProgressBar(0, maxLoad);
        this.add(prog, BorderLayout.CENTER);
        prog.setValue(initLoad);
        this.setDefaultCloseOperation(defaultCloseOperation);
        this.setSize(new Dimension(400, 200));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.getContentPane().setVisible(true);
        this.setVisible(true);

    }
    public void setProgress(int progress){
        this.prog.setValue(progress);
    }
    public int getProgress(){
        return this.prog.getValue();
    }
}
