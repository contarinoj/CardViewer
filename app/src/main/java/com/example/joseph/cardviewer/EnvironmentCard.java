package com.example.joseph.cardviewer;

/**
 * Created by Joseph on 2015-10-07.
 */
public class EnvironmentCard extends Card{
    private final String effect;

    EnvironmentCard(String id, String title, String created, String edited, String effect){
        super(id,title,created,edited);
        this.effect = effect;
    }

    @Override
    public String getBodyText() {
        return effect;
    }

    @Override
    public String getExtraInfo() {
        return "Environment cards remain in play until replaced by another Environment card or removed by some effect.";
    }
}
