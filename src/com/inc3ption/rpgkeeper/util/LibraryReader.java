package com.inc3ption.rpgkeeper.util;

import com.eventhorizonwebdesign.jfail.JFail;
import com.inc3ption.rpgkeeper.RPGKeeper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Trenton on 12/23/2015.
 */
public class LibraryReader extends BufferedReader {
    public LibraryReader(){
        super(new Reader(new File(RPGKeeper.LIBRARY_PATH_STRING)) {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        });
    }

    public Game[] readLibrary() throws IOException{
        String ws = null;
        if (new File(RPGKeeper.LIBRARY_PATH_STRING).length() <= 0){
            ws = this.readLine();
        }
        Game[] lib = new Game[256];
        int count = 0;
        while(ws != null && !ws.equals("")){
            JSONObject json = null;
            try {
                json = (JSONObject) new JSONParser().parse(ws);
            } catch (org.json.simple.parser.ParseException e){
                JFail.handleError(e, true);
                JFail.printErrorReport(e, System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop", true);
            }
            Game g = new Game(json.get("name").toString(), json.get("path").toString(), json.get("type").toString(), json.get("author").toString(), json.get("author_link").toString(),
                    json.get("rss").toString(), json.get("img").toString(), Integer.parseInt(json.get("rating").toString()));
            lib[count] = g;
            count++;
            ws = this.readLine();
        }
        return lib;
    }

}
