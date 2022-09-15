// 2. Converting attributes

package converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    static String testFile = "test.txt";

    static String removeQuotes(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static void printXml(HashMap<String, String> attributes, String main, String content) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(main).append(" ");
        for (var entry: attributes.entrySet()) {
            sb.append(entry.getKey().substring(1)).append(" = \"").append(entry.getValue()).append("\" ");
        }
        if (content.length() == 0) sb.append("/>");
        else {
            sb.deleteCharAt(sb.length() - 1);
            sb.append(">").append(content).append("</").append(main).append(">");
        }
        System.out.println(sb);
    }

    static void manualJsonToXml(String input) {
        JSONObject json = new JSONObject(input);
        Iterator<String> keys = json.keys();
        HashMap<String, String> attributes = new HashMap<>();
        String content = "";
        String main = "";

        while (keys.hasNext()) {
            String key = keys.next();
            main = key;
            if (json.get(key).toString().charAt(0) != '{') {
                jsonToXML(input); return;
            }
            JSONObject nested = new JSONObject(json.get(key).toString());

            Iterator<String> nestedKeys = nested.keys();
            while (nestedKeys.hasNext()) {
                String nestedKey = nestedKeys.next();
                if (nestedKey.charAt(0) == '@') attributes.put(nestedKey, nested.get(nestedKey).toString());
                if (nestedKey.charAt(0) == '#') {
                    if (nested.get(nestedKey).toString().equals("null")) content = "";
                    else content = nested.get(nestedKey).toString();
                }
            }
        }
        printXml(attributes, main, content);
    }

    static void manualXmlToJson(String input) {
        StringBuilder openingTag = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        int i = 1; boolean nullFlag = false;
        while (true) {
            if (input.charAt(i) == '/') {
                nullFlag = true; break;
            }
            if (input.charAt(i) == '>') break;
            openingTag.append(input.charAt(i++));
        }
        if (!nullFlag) {
            i++;
            while (true) {
                if (input.charAt(i) == '<') break;
                middle.append(input.charAt(i++));
            }
        }
        String[] attributes = openingTag.toString().split(" ");
        if (attributes.length == 1) xmlToJSON(input);
        else {
            String main = attributes[0];
            JSONObject jo = new JSONObject();
            JSONObject temp = new JSONObject();
            for (int j = 1; j < attributes.length; j += 3) {
                temp.put("@"+attributes[j], removeQuotes(attributes[j+2]));
            }
            if (middle.length() == 0) temp.put("#" + main, JSONObject.NULL);
            else temp.put("#" + main, middle);
            jo.put(main, temp);
            System.out.println(jo);
        }
    }

    static void jsonToXML(String jsonContent) {
        JSONObject json = new JSONObject(jsonContent);

        Iterator<String> keys = json.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (json.get(key) == JSONObject.NULL) json.put(key, "");
        }

        String xml = XML.toString(json);
        System.out.println(xml);
    }
    static void xmlToJSON(String xmlContent) {
        try {
            JSONObject json = XML.toJSONObject(xmlContent);
            Iterator<String> keys = json.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                if (json.get(key).toString().length() == 0) json.put(key, JSONObject.NULL);
            }

            String jsonString = json.toString();
            System.out.println(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            String input = new String(Files.readAllBytes(Paths.get(testFile)));
            if (input.charAt(0) == '{') manualJsonToXml(input);
            else manualXmlToJson(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
