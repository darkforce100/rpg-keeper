package com.inc3ption.rpgkeeper;

import com.inc3ption.rpgkeeper.ui.KeeperFrame;
import com.inc3ption.rpgkeeper.ui.LoaderFrame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import com.eventhorizonwebdesign.jfail.*;
import com.inc3ption.rpgkeeper.util.Game;
import com.inc3ption.rpgkeeper.util.LibraryReader;
import com.inc3ption.rpgkeeper.util.LibraryWriter;

/**
 * Created by Trenton on 11/25/2015.
 */
public class RPGKeeper {
    public static String LIBRARY_PATH_STRING = "";
    public static Game[] LIBRARY = new Game[2048];
    public static void main(String[] args){
        boolean cont;
        LoaderFrame mainLoader = new LoaderFrame("RPGKeeper", "RPGKeeper is loading...", 100, 0, JFrame.EXIT_ON_CLOSE);
        String OS;
        String INSTALL_PATH_STRING;
        if(System.getProperty("os.name").toLowerCase().contains("windows".toLowerCase())){
            OS = "WINDOWS";
            INSTALL_PATH_STRING = System.getProperty("user.home") + System.getProperty("file.separator") + "AppData" + System.getProperty("file.separator") + "Local" + System.getProperty("file.separator") + "RPGKeeper";
        } else if (System.getProperty("os.name").toLowerCase().contains("os x".toLowerCase())){
            OS = "MAC";
            INSTALL_PATH_STRING = System.getProperty("user.home") + System.getProperty("file.separator") + "Library" + System.getProperty("file.separator") + "Application Support" + System.getProperty("file.separator") + "RPGKeeper";
        } else {
            OS = "LINUX";
            INSTALL_PATH_STRING = System.getProperty("user.home") + System.getProperty("file.separator") + ".RPGKeeper";
        }
        System.out.println("OS = " + OS);
        System.out.println("INSTALL_PATH = " + INSTALL_PATH_STRING);
        mainLoader.setProgress(2);
        File installPath = new File(INSTALL_PATH_STRING);
        if(installPath.exists() && !installPath.isDirectory()) {
            cont = installPath.delete();
            checkIfErrorThrown(cont);
        }
        if(!installPath.exists()){
            cont = installPath.mkdirs();
            checkIfErrorThrown(cont);
        }
        mainLoader.setProgress(4);
        LIBRARY_PATH_STRING = INSTALL_PATH_STRING + System.getProperty("file.separator") + "lib.json";
        System.out.println("LIBRARY_PATH = " + LIBRARY_PATH_STRING);
        File lib = new File(LIBRARY_PATH_STRING);
        if(lib.exists() && lib.isDirectory()) {
            cont = lib.delete();
            checkIfErrorThrown(cont);
            tryToWrite(lib);
        }
        if(!installPath.exists() || !lib.exists()){
            tryToWrite(lib);
        }

        System.out.println("Reading...");
        try {
            LibraryReader reader = new LibraryReader();
            reader.readLibrary();
            System.out.println("Library read.");
        } catch (IOException e){
            JFail.showErrorDialog(e, true);
            JFail.printErrorReport(e, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
        }
        System.out.println("Starting RPG Keeper...");
        new KeeperFrame();
        System.out.println("Welcome.");
        mainLoader.dispose();
    }

    private static void tryToWrite(File lib) {
        boolean cont;
        try {
            cont = lib.createNewFile();
            checkIfErrorThrown(cont);
            LibraryWriter writer = new LibraryWriter();
            writer.append(System.getProperty("line.separator"));
            writer.close();
        } catch (IOException e) {
            JFail.showErrorDialog(e, true);
            JFail.printErrorReport(e, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
        }
    }

    private static void checkIfErrorThrown(boolean cont) {
        if (!cont){
            try {throw new IOException();}
            catch (IOException e){
                JFail.showErrorDialog(e, true);
                JFail.printErrorReport(e, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
            }
        }
    }
}
