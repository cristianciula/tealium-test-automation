package helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReaderHelper {

    public static String extractValue(String name, String key) {
        JSONParser parser = new JSONParser();
        String jsonFilePath = System.getProperty("user.dir")+"//src//test//java//testdatafiles//"+name+".json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Parse the JSON file into a JSONObject
            Object obj = parser.parse(reader);

            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;

                // Check if nestedKey is empty or null
                if (key == null || key.isEmpty()) {
                    // Extract a non-nested object value directly
                    return jsonObject.toString();
                }

                // Extract the nested object value or array
                Object nestedObject = getNestedValue(jsonObject, key);
                return nestedObject != null ? nestedObject.toString() : null;
            } else if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;

                // Extract the entire array
                return jsonArray.toString();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getNestedValue(JSONObject jsonObject, String nestedKey) {
        String[] keys = nestedKey.split("\\.");

        JSONObject currentObject = jsonObject;
        for (int i = 0; i < keys.length - 1; i++) {
            Object nestedObject = currentObject.get(keys[i]);

            if (nestedObject instanceof JSONObject) {
                currentObject = (JSONObject) nestedObject;
            } else {
                return null;
            }
        }

        return currentObject.get(keys[keys.length - 1]);
    }
}
