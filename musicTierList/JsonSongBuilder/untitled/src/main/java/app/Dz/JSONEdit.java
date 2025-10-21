package app.Dz;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class JSONEdit {


    public static void addSong(String filePath, String title, String tier, String imageLink) {
        try {
            // 1️⃣ Read the existing JSON file (or create new if empty)
            JsonObject jsonObject;
            try (FileReader reader = new FileReader(filePath)) {
                jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            } catch (IOException | JsonSyntaxException e) {
                // If file is empty or invalid, start fresh
                jsonObject = new JsonObject();
                jsonObject.add("songs", new JsonArray());
            }

            // 2️⃣ Get the "songs" array
            JsonArray songsArray = jsonObject.getAsJsonArray("songs");

            // 3️⃣ Create a new song object
            JsonObject newSong = new JsonObject();
            newSong.addProperty("title", title);
            newSong.addProperty("tier", tier);
            newSong.addProperty("imageLink", imageLink);

            // 4️⃣ Add the new song to the array
            songsArray.add(newSong);

            // 5️⃣ Write back to file with pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(gson.toJson(jsonObject));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
