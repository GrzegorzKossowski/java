/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author grze
 */
public class Chapter {
    
    private Integer id;
    private String flag;
    private String title;
    private String content;

    public Chapter() {
    }

    public Chapter(Integer id, String flag, String title) {
        this.id = id;
        this.flag = flag;
        this.title = title;
        this.content = "Bla bla bla bla bla";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" + "id=" + id + ", flag=" + flag + ", title=" + title + '}';
    }
    
        
    
}
