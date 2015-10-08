package com.example.joseph.cardviewer;

/**
 * Created by Joseph on 2015-10-07.
 */
public class TrapCard extends Card{
    private final String body;
    private final String trigger;

    TrapCard(String id, String title, String created, String edited, String body, String trigger){
        super(id,title,created,edited);
        this.body = body;
        this.trigger = trigger;
    }
}
