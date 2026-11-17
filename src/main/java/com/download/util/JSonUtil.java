package com.download.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSonUtil {

    public static interface Public {
    }

    public static interface Internal extends Public {
    }

    public static JsonObject toJSON(Object o, String viewMode) {
        try {
            ObjectWriter viewWriter = new ObjectMapper().writerWithView(JSonUtil.Public.class);
            if ("Internal".equalsIgnoreCase(viewMode)) {
                viewWriter = new ObjectMapper().writerWithView(JSonUtil.Internal.class);
            }
            String jsonInString = viewWriter.with(new SimpleDateFormat("yyyy-MM-dd")).writeValueAsString(o);
            Gson gson = new GsonBuilder()//.setDateFormat("dd-MM-yyyy")
                    .setPrettyPrinting().create();
            JsonElement element = gson.fromJson(jsonInString, JsonElement.class);
            JsonObject json = element.getAsJsonObject();
            return json;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String toPrettyPrint(JsonObject json) {
        String pp = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            pp = gson.toJson(json);
        } catch (NullPointerException ex) {
            Logger.getLogger(JSonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pp;
    }

    public static JsonObject mergeJSON(JsonObject json1, JsonObject json2) {
        try {
            for (Map.Entry<String, JsonElement> entry : json2.entrySet()) {
                json1.add(entry.getKey(), entry.getValue());
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(JSonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json1;
    }

    public static JsonObject msgJSON(ErrorCode ec, long id) {
        JsonObject json = new JsonObject();
        json.addProperty("ErrorCode", ec.name());
        json.addProperty("ErrorDescription", ec.msg());
        if (id != 0) {
            json.addProperty("uid", id);
        }
        return json;
    }
    
    public static JsonElement strToJson(String str) {
        JsonParser parser = new JsonParser();
        JsonElement jse = parser.parse("{'name':'Juan','age':22,'birthday':'Wed Feb 26 20:39:53 CET 2014'}");
       return jse;
    }
}
