package me.mrkirby153.chieves.updater;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ThreadUpdateChecker extends Thread {

    public ThreadUpdateChecker() {
        setName("Chieves update checker thread");
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        // Get the last successful build
        try {
            URL url = new URL(UpdateChecker.latestBuildNumber);
            InputStream is = url.openStream();
            UpdateChecker.newVersion = is.read();
            // Get the MC version of the build
            URL buildUrl = new URL(UpdateChecker.updateCheckUrl);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(new JsonReader(new InputStreamReader(buildUrl.openStream())));
            JsonObject jObject = element.getAsJsonObject();
            JsonArray array = jObject.getAsJsonArray("artifacts");
            jObject = array.get(0).getAsJsonObject();
            String fileName = jObject.get("fileName").toString();
            System.out.println(fileName);
        } catch (Exception e) {
            UpdateChecker.updateFailure = true;
            e.printStackTrace();
        }
        UpdateChecker.updateDone = true;
    }
}
