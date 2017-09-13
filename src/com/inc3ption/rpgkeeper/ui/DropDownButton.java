package com.inc3ption.rpgkeeper.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Trenton on 12/27/2015.
 */
public class DropDownButton extends AbstractButton
{
    JButton actionButton;
    JToggleButton menuButton;
    JPopupMenu popupMenu;

    public DropDownButton(JButton _actionButton, JPopupMenu _popupMenu) {
        this.popupMenu = _popupMenu;
        this.actionButton = _actionButton;

        setLayout(new BorderLayout());
        actionButton.setBorderPainted(false);
        add(BorderLayout.CENTER, actionButton);
        menuButton = new JToggleButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(DropDownButton.class.getResource("/com/inc3ption/rpgkeeper/ui/images/down.jpg"))));
        menuButton.setPreferredSize(new Dimension(15, 10));
        add(BorderLayout.EAST, menuButton);
        menuButton.setBorderPainted(false);

        MouseAdapter ma = new MouseAdapter() {
            public void mouseClicked(MouseEvent me) { }
            public void mousePressed(MouseEvent me) {
                if (me.getSource() == actionButton) {
                    menuButton.setSelected(true);
                }
            }
            public void mouseReleased(MouseEvent me) {
                if (me.getSource() == actionButton) {
                    menuButton.setSelected(false);
                }
            }
            public void mouseEntered(MouseEvent me) {
                setRolloverBorder();
            }
            public void mouseExited(MouseEvent me) {
                unsetRolloverBorder();
            }
        };

        actionButton.addMouseListener(ma);
        menuButton.addMouseListener(ma);

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                popupMenu.show(actionButton, 0, actionButton.getSize().height);
            }
        });
    }

    protected void setRolloverBorder() {
        actionButton.setBorderPainted(true);
        menuButton.setBorderPainted(true);
    }

    protected void unsetRolloverBorder() {
        actionButton.setBorderPainted(false);
        menuButton.setBorderPainted(false);
    }
}
