// 3. Nesting season

package converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class XmlElement {
    String path;
    String value;
    HashMap<String, String> attributes = new HashMap<>();

    XmlElement(String path, String value, HashMap<String, String> attributes) {
        this.path = path; this.value = value; this.attributes = attributes;
    }

    public void printElement() {
        System.out.println("Element:\npath = " + path);
        if (value != null) {
            if (value.equals("null")) System.out.println("value = null");
            else if (value.equals("empty")) System.out.println("value = \"\"");
            else System.out.println("value = \"" + value + "\"");
        }
        if (attributes != null) {
            if (!attributes.isEmpty()) {
                System.out.println("attributes:");
                for (var entry : attributes.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
            }
        }
        System.out.println();
    }

    public HashMap<String, String> getAttributes() { return attributes; }
}

class printXmlElements {
    String xmlContent;
    HashMap<String, Integer> counter = new HashMap<>();
    int ctr = 0;
    ArrayList<String> pathStack = new ArrayList<>();
    ArrayList<XmlElement> elements = new ArrayList<>();

    printXmlElements(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    String[] getTagsArray() {
        String[] lines = xmlContent.split("\\n");
        StringBuilder sb = new StringBuilder();
        for (String line: lines) sb.append(line.trim());
        return sb.toString().split("><");
    }

    String sanitizeTag(String tag) {
        StringBuilder sb = new StringBuilder();
        if (tag.charAt(0) != '<') {
            sb.append("<");
        }
        sb.append(tag);
        if (sb.charAt(sb.length() - 1) != '>') sb.append(">");
        //System.out.println(sb);
        return sb.toString();
    }

    boolean isOpeningTag(String tag) {
        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) == '/') return false;
        }
        return true;
    }

    boolean isNormalTag(String tag) {
        int tagCount = 0; int slashCount = 0;
        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) == '<' || tag.charAt(i) == '>') tagCount++;
            if (tag.charAt(i) == '/') slashCount++;
        }
        return (tagCount == 4 && slashCount == 1);
    }

    boolean isNullTag(String tag) {
        int tagCount = 0;
        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) == '<' || tag.charAt(i) == '>') tagCount++;
        }
        return (tagCount == 2 && tag.charAt(tag.length() - 2) == '/');
    }

    void createElement(String value, HashMap<String, String> attributes) {
        StringBuilder path = new StringBuilder();
        for (String p: pathStack) {
            path.append(p).append(", ");
        }
        path.deleteCharAt(path.length() - 1); path.deleteCharAt(path.length() - 1);
        XmlElement ele = new XmlElement(path.toString(), value, attributes);
        elements.add(ele);
    }

    void processOpeningTag(String tag) {
        StringBuilder tagName = new StringBuilder();
        HashMap<String, String> attributes = new HashMap<>();
        int i = 1; int attr = -1;
        while (tag.charAt(i) != ' ' && tag.charAt(i) != '>') {
            if (tag.charAt(i + 1) == ' ') attr = i+1;
            tagName.append(tag.charAt(i++));
        }
        if (attr != -1) {
            while (tag.charAt(attr) != '>') {
                StringBuilder key = new StringBuilder(); StringBuilder val = new StringBuilder();
                while (tag.charAt(attr) != '=') {
                    key.append(tag.charAt(attr++));
                }
                if (tag.charAt(attr + 1) == ' ') attr += 2;
                else attr++;
                while (tag.charAt(attr) != ' ' && tag.charAt(attr) != '>') {
                    val.append(tag.charAt(attr++));
                }
                attributes.put(key.toString().trim(), val.toString().trim());
            }
        }
        pathStack.add(tagName.toString()); i = 0;
        counter.put(tagName.toString(), ctr++);
        createElement(null, attributes);
    }

    void processNormalTag(String tag) {
        StringBuilder tagName = new StringBuilder();
        HashMap<String, String> attributes = new HashMap<>();
        int i = 1; int attr = -1;
        while (tag.charAt(i) != ' ' && tag.charAt(i) != '>') {
            if (tag.charAt(i + 1) == ' ') attr = i+1;
            tagName.append(tag.charAt(i++));
        }
        if (attr != -1) {
            while (tag.charAt(attr) != '>') {
                StringBuilder key = new StringBuilder(); StringBuilder val = new StringBuilder();
                while (tag.charAt(attr) != '=') {
                    key.append(tag.charAt(attr++));
                }
                if (tag.charAt(attr + 1) == ' ') attr += 2;
                else attr++;
                while (tag.charAt(attr) != ' ' && tag.charAt(attr) != '>') {
                    val.append(tag.charAt(attr++));
                }
                attributes.put(key.toString().trim(), val.toString().trim());
            }
        }
        pathStack.add(tagName.toString()); i = 0;
        counter.put(tagName.toString(), ctr++);
        StringBuilder val = new StringBuilder("");
        while (tag.charAt(i) != '>') i++;
        i++;
        while (tag.charAt(i) != '<') val.append(tag.charAt(i++));
        if (attributes.isEmpty()) attributes = null;
        if (val.isEmpty()) val = new StringBuilder("empty");
        createElement(val.toString(), attributes);
        pathStack.remove(pathStack.size() - 1);
    }

    void processNullTag(String tag) {
        StringBuilder tagName = new StringBuilder();
        HashMap<String, String> attributes = new HashMap<>();
        int i = 1; int attr = -1;
        while (tag.charAt(i) != ' ' && tag.charAt(i) != '>') {
            if (tag.charAt(i + 1) == ' ') attr = i+1;
            tagName.append(tag.charAt(i++));
        }
        if (attr != -1) {
            while (tag.charAt(attr) != '/' && tag.charAt(attr + 1) != '/') {
                attr++;
                StringBuilder key = new StringBuilder(); StringBuilder val = new StringBuilder();
                while (tag.charAt(attr) != '=') {
                    key.append(tag.charAt(attr++));
                }
                if (tag.charAt(attr + 1) == ' ') attr += 2;
                else attr++;
                while (tag.charAt(attr) != ' ' && tag.charAt(attr) != '/') {
                    val.append(tag.charAt(attr++));
                }
                attributes.put(key.toString().trim(), val.toString().trim());
            }
        }
        pathStack.add(tagName.toString()); i = 0;
        counter.put(tagName.toString(), ctr++);
        if (attributes.isEmpty()) attributes = null;
        createElement("null", attributes);
        pathStack.remove(pathStack.size() - 1);
    }

    void processClosingTag(String tag) {
        String opener = pathStack.get(pathStack.size() - 1);
        if (counter.get(opener) == ctr - 1) {
            HashMap<String, String> attributes = elements.get(elements.size() - 1).getAttributes();
            elements.remove(elements.size() - 1);
            createElement("empty", attributes);
        }
        pathStack.remove(pathStack.size() - 1);
    }

    void processTag(String tag) {
        int i = 1;
        if (isOpeningTag(tag)) {
            processOpeningTag(tag);
        } else if (isNormalTag(tag)) {
            processNormalTag(tag);
        } else if (isNullTag(tag)) {
            processNullTag(tag);
        } else {
            processClosingTag(tag);
        }
    }

    void parseXml() {
        String[] tags = getTagsArray();
        for (String tag: tags) {
            String cleanTag = sanitizeTag(tag);
            processTag(cleanTag);
        }
    }

    public void run() {
        parseXml();
        for (XmlElement ele: elements) {
            //System.out.println("ATTR : " + ele.getAttributes());
            ele.printElement();
        }
    }
}


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
//            if (input.charAt(0) == '{') manualJsonToXml(input);
//            else manualXmlToJson(input);
            printXmlElements pxe = new printXmlElements(input);
            pxe.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
