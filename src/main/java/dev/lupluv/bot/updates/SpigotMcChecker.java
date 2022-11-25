package dev.lupluv.bot.updates;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class SpigotMcChecker {

    private static final String USER_AGENT  = "LUPLUV";// Change this!

    public static String getNewestVersion(Plugin plugin){
        try {
            URL url = null;
            if(plugin == Plugin.SIMPLE_GAMEMODE) url = new URL("https://api.spiget.org/v2/resources/86743/versions/latest");
            if(plugin == Plugin.CRAFTATTACK8) url = new URL("https://api.spiget.org/v2/resources/91769/versions/latest");
            assert url != null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", USER_AGENT);// Set User-Agent

            // If you're not sure if the request will be successful,
            // you need to check the response code and use #getErrorStream if it returned an error code
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);

            // This could be either a JsonArray or JsonObject
            JsonElement element = new JsonParser().parse(reader);
            if (element.isJsonArray()) {
                // Is JsonArray
            } else if (element.isJsonObject()) {
                // Is JsonObject
                JsonObject jsonObject = element.getAsJsonObject();
                String version = jsonObject.get("name").getAsString();
                System.out.println("Newest Version: " + version);
                return version;
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static String getNewestUpdateTitle(Plugin plugin){
        try {
            URL url = null;
            if(plugin == Plugin.SIMPLE_GAMEMODE) url = new URL("https://api.spiget.org/v2/resources/86743/updates/latest");
            if(plugin == Plugin.CRAFTATTACK8) url = new URL("https://api.spiget.org/v2/resources/91769/updates/latest");
            assert url != null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", USER_AGENT);// Set User-Agent

            // If you're not sure if the request will be successful,
            // you need to check the response code and use #getErrorStream if it returned an error code
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);

            // This could be either a JsonArray or JsonObject
            JsonElement element = new JsonParser().parse(reader);
            if (element.isJsonArray()) {
                // Is JsonArray
            } else if (element.isJsonObject()) {
                // Is JsonObject
                JsonObject jsonObject = element.getAsJsonObject();
                String title = jsonObject.get("title").getAsString();
                System.out.println("Newest Update Title: " + title);
                return title;
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static String getNewestUpdateDescription(Plugin plugin){
        try {
            URL url = null;
            if(plugin == Plugin.SIMPLE_GAMEMODE) url = new URL("https://api.spiget.org/v2/resources/86743/updates/latest");
            if(plugin == Plugin.CRAFTATTACK8) url = new URL("https://api.spiget.org/v2/resources/91769/updates/latest");
            assert url != null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", USER_AGENT);// Set User-Agent

            // If you're not sure if the request will be successful,
            // you need to check the response code and use #getErrorStream if it returned an error code
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);

            // This could be either a JsonArray or JsonObject
            JsonElement element = new JsonParser().parse(reader);
            if (element.isJsonArray()) {
                // Is JsonArray
            } else if (element.isJsonObject()) {
                // Is JsonObject
                JsonObject jsonObject = element.getAsJsonObject();
                byte[] descBytes = Base64.getDecoder().decode(jsonObject.get("description").getAsString());
                String desc = new String(descBytes);
                System.out.println("Newest Update Description: " + desc);
                return desc;
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}
