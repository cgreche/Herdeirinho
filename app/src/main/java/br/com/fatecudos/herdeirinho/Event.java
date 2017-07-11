package br.com.fatecudos.herdeirinho;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jacsi on 14/05/2017.
 */

public class Event implements Serializable {

    private int id;
    private String name;
    private Date date;
    private String local;
    private String description;

    public Event(){
        id = -1;
        name = "";
        date = new Date();
        local = "";
        description = "";
    }

    public Event(int id, String name, Date date, String local, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.local = local;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dates) {
        this.date = dates;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
