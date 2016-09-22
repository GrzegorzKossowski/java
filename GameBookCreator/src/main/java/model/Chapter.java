/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import app.Flags;
import java.io.Serializable;

/**
 *
 * @author grze
 */
public class Chapter implements Serializable {

    //how many chapters
    private static Integer count = 0;

    public static void setCount(int size) {
        count = size;
    }

    private Integer id; //unique id
    private Integer number; //chapters number
    private Flags flag; //chapters flag eg. DEAD "end"
    private String title;
    private String content; //chapters text contetn
    private boolean fixed;  // can't be shuffled

    public Chapter() {
    }

    public Chapter(Chapter c) {
        this.id = c.getId();
        this.number = c.getNumber();
        this.flag = c.getFlag();
        this.fixed = c.isFixed();
        this.title = c.getTitle();
        this.content = c.getContent();
    }

    public Chapter(Flags flag, String title) {
        count++;
        this.id = count;
        this.number = count;
        this.flag = flag;
        this.title = title;
        this.content = "Let the story continue...";
        this.fixed = false;
    }

    public Chapter(Boolean fixed, Flags flag, String title) {
        count++;
        this.id = count;
        this.number = count;
        this.flag = flag;
        this.title = title;
        this.content = "Let the story continue...";
        this.fixed = fixed;
    }

    public Chapter(Integer number, Boolean fixed, Flags flag, String title) {
        count++;
        this.id = count;
        this.number = number;
        this.flag = flag;
        this.title = title;
        this.content = "Let the story continue...";
        this.fixed = fixed;
    }

    public Integer getId() {
        return id;
    }

    public Flags getFlag() {
        return flag;
    }

    public void setFlag(Flags flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("id: %d (%s) [%d] %s {%b}",
                getId(), getFlag().toString(), getNumber(), getTitle(), isFixed());
    }

}
