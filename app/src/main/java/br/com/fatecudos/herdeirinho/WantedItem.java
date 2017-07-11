package br.com.fatecudos.herdeirinho;

import java.util.Date;

import static android.R.attr.id;

/**
 * Created by jacsi on 04/06/2017.
 */

public class WantedItem {

    private String name;
    private String description;
    private String imageURL;

    public WantedItem(){
        name = "";
        description = "";
        imageURL = "";
    }

    public WantedItem(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }
}
