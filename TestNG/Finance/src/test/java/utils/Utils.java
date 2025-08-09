package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static int generateRandomNumber(int min,int max){

        double randomID = Math.random()*(max-min)+min;
        return (int) randomID;

    }

    // for Storing  Automatically generated data in user.json of Resources

    public static void storeUserInfo(String filePath, JSONObject jsonObject) throws IOException, ParseException {

        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(filePath));
        jsonArray.add(jsonObject);
        FileWriter fileWriter=new FileWriter(filePath);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

    }
}
