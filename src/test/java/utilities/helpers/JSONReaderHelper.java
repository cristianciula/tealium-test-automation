package utilities.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReaderHelper {

    public static String extractValue(String fileName, String arrayKey, String keyPath) {
        JSONParser parser = new JSONParser();
        String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//testdatafiles//" + fileName + ".json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Parse the JSON file into a JSONObject
            Object obj = parser.parse(reader);

            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;

                // If arrayKey is not provided or empty, treat it as a nested object lookup
                if (arrayKey == null || arrayKey.isEmpty()) {
                    Object value = getNestedValue(jsonObject, keyPath);
                    return value != null ? value.toString() : null;
                } else {
                    // If arrayKey is provided, extract values from the array
                    Object arrayObject = jsonObject.get(arrayKey);
                    if (arrayObject instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) arrayObject;
                        StringBuilder result = new StringBuilder();
                        for (Object item : jsonArray) {
                            if (item instanceof JSONObject) {
                                JSONObject jsonItem = (JSONObject) item;
                                Object value = getNestedValue(jsonItem, keyPath);
                                if (value != null) {
                                    result.append(value).append(", ");
                                }
                            }
                        }
                        // Remove the trailing comma and space
                        if (!result.isEmpty()) {
                            result.setLength(result.length() - 2);
                        }
                        return result.toString();
                    }
                }
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
