package com.example.joseph.cardviewer;

/**
 * Created by Joseph on 2015-10-07.
 */
public abstract class Card {
    protected final String objectId;
    protected final String title;
    protected final String createdAt;
    protected final String updatedAt;

    public Card(String id, String title, String created, String edited){
        objectId = id;
        this.title = title;
        createdAt = created;
        updatedAt = edited;
    }

    public String getTitle(){
        return title;
    }


}
