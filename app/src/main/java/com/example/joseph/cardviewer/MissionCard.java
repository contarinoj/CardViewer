package com.example.joseph.cardviewer;

/**
 * Created by Joseph on 2015-10-07.
 */
public class MissionCard extends Card{
    private final String instructions;
    private final String summary;
    private final String success;
    private final String failure;

    MissionCard(String id, String title, String created, String edited, String instructions,
                String summary, String success, String failure){
        super(id,title,created,edited);
        this.instructions = instructions;
        this.summary = summary;
        this.success = success;
        this.failure = failure;
    }

    @Override
    public String getBodyText() {
        //todo use a string builder
        return summary + "\n\n" + "<b>Success<\b>: " + success + "\n\n<b>Failure<\b>:" + failure;
    }

    @Override
    public String getExtraInfo(){
        return instructions;
    }
}
