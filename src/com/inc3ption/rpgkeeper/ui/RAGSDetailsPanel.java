package com.inc3ption.rpgkeeper.ui;

import com.eventhorizonwebdesign.jfail.JFail;
import com.inc3ption.rpgkeeper.RPGKeeper;
import com.inc3ption.rpgkeeper.util.Game;
import com.inc3ption.rpgkeeper.util.LibraryWriter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trenton on 1/4/2016.
 */
public class RAGSDetailsPanel extends JPanel {
    public RAGSDetailsPanel(boolean edit, final JFrame parent){
        this.setLayout(new GridLayout(10, 1, 0, 20));

        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Title: ");
        namePanel.add(titleLabel, BorderLayout.WEST);
        final JTextArea titleArea = new JTextArea(1,30);
        titleArea.setEditable(true);
        titleArea.setToolTipText("Title");
        namePanel.add(titleArea, BorderLayout.CENTER);
        namePanel.setSize(500, 50);
        this.add(namePanel);

        JPanel pathPanel = new JPanel(new BorderLayout());
        JLabel pathLabel = new JLabel("Game Path: ");
        pathPanel.add(pathLabel, BorderLayout.WEST);
        final JTextArea pathArea = new JTextArea(1,30);
        pathArea.setEditable(true);
        pathArea.setToolTipText("Path to game");
        pathPanel.add(pathArea, BorderLayout.CENTER);
        JButton browsePathButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(RAGSDetailsPanel.class.getResource("/com/inc3ption/rpgkeeper/ui/images/folder.png"))));
        browsePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser pathfc = new JFileChooser();
                FileFilter exeFilter = new FileFilter() {

                    public String getDescription() {
                        return "Application (*.exe)";
                    }

                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            return f.getName().toLowerCase().endsWith(".exe");
                        }
                    }
                };
                pathfc.setFileFilter(exeFilter);
                int returnVal = pathfc.showOpenDialog(RAGSDetailsPanel.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    pathArea.setText(pathfc.getSelectedFile().toPath().toString());
                } else {
                }
            }
        });
        pathPanel.add(browsePathButton, BorderLayout.EAST);
        pathPanel.setSize(500, 50);
        this.add(pathPanel);

        JPanel authorPanel = new JPanel(new BorderLayout());
        JLabel authorLabel = new JLabel("Author: ");
        authorPanel.add(authorLabel, BorderLayout.WEST);
        final JTextArea authorArea = new JTextArea(1,30);
        authorArea.setEditable(true);
        authorArea.setToolTipText("Author name");
        authorPanel.add(authorArea, BorderLayout.CENTER);
        authorPanel.setSize(500, 50);
        this.add(authorPanel);

        JPanel authorLinkPanel = new JPanel(new BorderLayout());
        JLabel authorLinkLabel = new JLabel("Author\'s Site: ");
        authorLinkPanel.add(authorLinkLabel, BorderLayout.WEST);
        final JTextArea authorLinkArea = new JTextArea(1,30);
        authorLinkArea.setEditable(true);
        authorLinkArea.setToolTipText("Author\'s website");
        authorLinkPanel.add(authorLinkArea, BorderLayout.CENTER);
        authorLinkPanel.setSize(500, 50);
        this.add(authorLinkPanel);

        JPanel rssPanel = new JPanel(new BorderLayout());
        JLabel rssLabel = new JLabel("RSS Feed Link: ");
        rssPanel.add(rssLabel, BorderLayout.WEST);
        final JTextArea rssArea = new JTextArea(1,30);
        rssArea.setEditable(true);
        rssArea.setToolTipText("RSS Feed Link");
        rssPanel.add(rssArea, BorderLayout.CENTER);
        rssPanel.setSize(500, 50);
        this.add(rssPanel);

        JPanel imagePanel = new JPanel(new BorderLayout());
        JLabel imageLabel = new JLabel("Icon Image: ");
        imagePanel.add(imageLabel, BorderLayout.WEST);
        final JTextArea imageArea = new JTextArea(1,30);
        imageArea.setEditable(true);
        imageArea.setToolTipText("RSS Feed Link");
        imagePanel.add(imageArea, BorderLayout.CENTER);
        JButton browseImageButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(RAGSDetailsPanel.class.getResource("/com/inc3ption/rpgkeeper/ui/images/folder.png"))));
        browseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser imagefc = new JFileChooser();
                FileFilter imgFilter = new FileFilter() {

                    public String getDescription() {
                        return "Image files (*.jpg, *.jpeg, *.png)";
                    }

                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            return (f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".jpeg") || f.getName().toLowerCase().endsWith(".png"));
                        }
                    }
                };
                imagefc.setFileFilter(imgFilter);
                int returnVal = imagefc.showOpenDialog(RAGSDetailsPanel.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    imageArea.setText(imagefc.getSelectedFile().toPath().toString());
                } else {
                }
            }
        });
        imagePanel.add(browseImageButton, BorderLayout.EAST);
        imagePanel.setSize(500, 50);
        this.add(imagePanel);

        JPanel buttonsPanel = new JPanel(new BorderLayout());
        JButton cancelButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(RAGSDetailsPanel.class.getResource("/com/inc3ption/rpgkeeper/ui/images/cancel.png"))));
        cancelButton.setText("Cancel");
        cancelButton.setHorizontalTextPosition(AbstractButton.RIGHT);
        cancelButton.setVerticalTextPosition(AbstractButton.CENTER);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.dispose();
                System.out.println("Game details editor closed.");
            }
        });
        buttonsPanel.add(cancelButton, BorderLayout.WEST);
        JButton okButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(RAGSDetailsPanel.class.getResource("/com/inc3ption/rpgkeeper/ui/images/tick.png"))));
        okButton.setText("Add Game");
        okButton.setHorizontalTextPosition(AbstractButton.RIGHT);
        okButton.setVerticalTextPosition(AbstractButton.CENTER);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RPGKeeper.LIBRARY[RPGKeeper.LIBRARY.length] = new Game(titleArea.getText(), pathArea.getText(), Game.TYPE_RAGS, authorArea.getText(), authorLinkArea.getText(), rssArea.getText(), imageArea.getText(), Game.RATING_UNRATED);
                try {
                    LibraryWriter writer = new LibraryWriter();
                    writer.writeLibrary();
                    writer.close();
                    System.out.println("Game successfully added.");
                } catch (IOException e1){
                    JFail.handleError(e1, true);
                    JFail.printErrorReport(e1, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
                }
                parent.dispose();
                System.out.println("Game details editor closed.");
            }
        });
        buttonsPanel.add(okButton, BorderLayout.EAST);
        buttonsPanel.setSize(500, 50);
        this.add(buttonsPanel);

        this.setVisible(true);
    }
}
