package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    //Method to read data from a json file
    public static JSONObject json(String name) {
        //Find automatically the directory containing the testDataFiles package
        String jsonPath = System.getProperty("user.dir")+"//src//test//java//testdatafiles//"+name+".json";

        //Reads the json file at the indicated location
        FileReader reader = null;
        try {
            reader = new FileReader(jsonPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Define the parser to parse the content of the json file
        JSONParser jsonParser = new JSONParser();

        //Define the returned Object
        JSONObject obj = null;
        try {
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
