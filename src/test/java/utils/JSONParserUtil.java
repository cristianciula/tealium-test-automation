package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONParserUtil {

    public static String extractValue(String name, String nestedKey) {
        JSONParser parser = new JSONParser();
        String jsonFilePath = System.getProperty("user.dir")+"//src//test//java//testdatafiles//"+name;

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Parse the JSON file into a JSONObject
            Object obj = parser.parse(reader);

            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;

                // Check if nestedKey is empty or null
                if (nestedKey == null || nestedKey.isEmpty()) {
                    // Extract a non-nested object value directly
                    return jsonObject.toString();
                }

                // Extract the nested object value or array
                Object nestedObject = getNestedValue(jsonObject, nestedKey);
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

    public static void main(String[] args) {
        String jsonFileName = "your-json-file"; // Specify the JSON file name (without the ".json" extension)

        // Example of extracting a nested object value
        String nestedValue = extractValue(jsonFileName, "topLevel.secondLevel.nestedValue");
        if (nestedValue != null) {
            System.out.println("Extracted Nested Object Value: " + nestedValue);
        } else {
            System.out.println("Nested Key not found in JSON.");
        }

        // Example of extracting a non-nested object value
        String nonNestedValue = extractValue(jsonFileName, null);
        if (nonNestedValue != null) {
            System.out.println("Extracted Non-Nested Object Value: " + nonNestedValue);
        } else {
            System.out.println("JSON Object not found.");
        }

        // Example of extracting an entire array
        String jsonArrayValue = extractValue(jsonFileName, null);
        if (jsonArrayValue != null) {
            System.out.println("Extracted JSON Array: " + jsonArrayValue);
        } else {
            System.out.println("JSON Array not found.");
        }
    }
}
