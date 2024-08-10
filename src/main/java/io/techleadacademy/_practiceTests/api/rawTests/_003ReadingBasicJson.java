package io.techleadacademy._practiceTests.api.rawTests;

//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _003ReadingBasicJson {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object object = parser.parse(new FileReader("src/test/resources/data/basicJsonObject.json"));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println(jsonObject.get("placed"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
