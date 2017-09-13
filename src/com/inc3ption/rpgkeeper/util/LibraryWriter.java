package com.inc3ption.rpgkeeper.util;

import com.inc3ption.rpgkeeper.RPGKeeper;

import java.io.*;

/**
 * Created by Trenton on 12/24/2015.
 */
public class LibraryWriter extends BufferedWriter{
    public LibraryWriter() throws IOException{
        super(new FileWriter(RPGKeeper.LIBRARY_PATH_STRING, false) {
            @Override
            public void write(char[] cbuf, int off, int len) {

            }
            @Override
            public void flush() {

            }
            @Override
            public void close() {

            }
        });
    }


    public void writeLibrary() throws IOException{
        //TODO
        for (int i = 0; i < RPGKeeper.LIBRARY.length; i++){
            this.append(RPGKeeper.LIBRARY[i].toJSON());
            this.append(System.getProperty("line.separator"));
        }
    }
}
