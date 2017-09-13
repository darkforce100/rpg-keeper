package com.inc3ption.rpgkeeper.util;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Trenton on 12/24/2015.
 */
public class Game {
    public static final String TYPE_RPGMAKER = "RPG Maker";
    public static final String TYPE_RAGS = "Rags";
    public static final String TYPE_EXE = "EXE";
    public static final String TYPE_TWINE = "Twine";

    public static final int RATING_UNRATED = 0;
    public static final int RATING_1 = 1;
    public static final int RATING_2 = 2;
    public static final int RATING_3 = 3;
    public static final int RATING_4 = 4;
    public static final int RATING_5 = 5;

    public static final String INTERNAL_ICON_RPGMAKER = "INTERNAL:RPGMAKER";
    public static final String INTERNAL_ICON_RAGS = "INTERNAL:RAGS";
    public static final String INTERNAL_ICON_EXE = "INTERNAL:EXE";
    public static final String INTERNAL_ICON_TWINE = "INTERNAL:TWINE";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorLink() {
        return authorLink;
    }

    public void setAuthorLink(String authorLink) {
        this.authorLink = authorLink;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String name;
    private String path;
    private String type;
    private String author;
    private String authorLink;
    private String rss;
    private String img;
    private int rating;

    public Game(String name, String path, String type, String author, String authorLink, String rss, String imgPath, int rating){
        this.name = name;
        this.path = path;
        this.type = type;
        this.author = author;
        this.authorLink = authorLink;
        this.rss = rss;
        this.img = imgPath;
        this.rating = rating;
    }

    public String toJSON() throws IOException{
        JSONObject obj = new JSONObject();
        obj.put("name", this.name);
        obj.put("path", this.path);
        obj.put("type", this.type);
        obj.put("author", this.author);
        obj.put("author_link", this.authorLink);
        obj.put("rss", this.rss);
        obj.put("img", this.img);
        obj.put("rating", this.rating);
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        return out.toString();
    }
}
