package com.example.joseph.cardviewer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Joseph on 2015-10-07.
 */
//TODO might want to make this a serializer too
public class CardDeserializer implements JsonDeserializer<Card> {
    @Override
    public Card deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jason = json.getAsJsonObject();
        String className = "";
        String base = "com.example.joseph.cardviewer.";

        try {
            if (jason.has("text")) {
                className = base + "EventCard";
            } else if (jason.has("effect")) {
                className = base + "EnvironmentCard";
            } else if (jason.has("body")) {
                className = base + "TrapCard";
            } else if (jason.has("instructions")) {
                className = base + "MissionCard";
            }
            Class<?> clz = Class.forName(className);
            return context.deserialize(json, clz);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            throw new JsonParseException(e);
        }
    }
}
