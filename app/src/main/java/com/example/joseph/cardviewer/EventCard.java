package com.example.joseph.cardviewer;

/**
 * Created by Joseph on 2015-10-07.
 */
public class EventCard extends Card{
    private final String text;

    EventCard(String id, String title, String created, String edited, String text){
        super(id,title,created,edited);
        this.text = text;
    }

    @Override
    public String getBodyText() {
        return text;
    }

    @Override
    public String getExtraInfo() {
        return "";
    }
}
