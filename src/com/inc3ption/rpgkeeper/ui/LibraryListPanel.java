package com.inc3ption.rpgkeeper.ui;

import com.eventhorizonwebdesign.jfail.JFail;
import com.inc3ption.rpgkeeper.RPGKeeper;
import com.inc3ption.rpgkeeper.util.LibraryReader;

import javax.swing.*;

/**
 * Created by Trenton on 1/4/2016.
 */
public class LibraryListPanel extends JScrollPane {
    private Object[][] data;
    private JTable libraryTable;
    public LibraryListPanel() {
        final String[] columnNames = {"Name",
                "Type",
                "Rating"};
        LibraryReader libraryReader = new LibraryReader();
        try {
            libraryReader.readLibrary();
        } catch (Exception e) {
            JFail.showErrorDialog(e, true);
            JFail.printErrorReport(e, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
        }
        if (RPGKeeper.LIBRARY.length > 0) {
            for (int i = 0; i < RPGKeeper.LIBRARY.length; i++){
                data[i][0] = RPGKeeper.LIBRARY[i].getName();
                data[i][1] = RPGKeeper.LIBRARY[i].getType();
                switch (RPGKeeper.LIBRARY[i].getRating()){
                    case 1:
                        data[i][2] = "\u2605";
                        break;
                    case 2:
                        data[i][2] = "\u2605 \u2605";
                        break;
                    case 3:
                        data[i][2] = "\u2605 \u2605 \u2605";
                        break;
                    case 4:
                        data[i][2] = "\u2605 \u2605 \u2605 \u2605";
                        break;
                    case 5:
                        data[i][2] = "\u2605 \u2605 \u2605 \u2605 \u2605";
                        break;
                    default:
                        data[i][2] = "";
                        break;
                }
            }
        }
        libraryTable = new JTable(data, columnNames);
        this.add(libraryTable);
        libraryTable.setFillsViewportHeight(true);
        this.setVisible(true);
    }

    public static void refresh(){
        //TODO
    }
}
