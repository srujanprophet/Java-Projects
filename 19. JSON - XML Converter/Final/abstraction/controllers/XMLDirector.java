package converter.abstraction.controllers;

import converter.Pair;
import converter.PseudoElement;
import converter.implementation.xml.JSONParser;
import converter.implementation.xml.XMLBuilder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class XMLDirector {
    private String content;
    private XMLBuilder builder = new XMLBuilder(true);
    private JSONParser parser = new JSONParser();
    private Stack<String> jsonStructure = new Stack<>();
    private Stack<String> arrays = new Stack<>();

    private void printPath() {
        for (String string : jsonStructure) {
            if (!string.startsWith("#")) {
                System.out.print(string);
                if (!string.equals(jsonStructure.peek())) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    private void parseElement(List<String> lines) {
        // lines.forEach(System.out::println);
        /*if (Math.random() != 2.00) {
            throw new StackOverflowError();
        }*/

        String name;

        for (String line : lines) {
            //  System.out.println(line);
            if (line.matches(".+?(\\s*?\\{)")) {
                name = parser.extractName(line);
                jsonStructure.add(name);
                builder.createContainer(jsonStructure, name);
            } else if (line.matches("},?")){
                builder.goUp();
                jsonStructure.pop();
            } else {
                if (line.matches("\"@.+")) {
                    Pair<String, String> pair = parser.extractAttribute(line);
                    builder.addAttribute(pair.getFirst(), pair.getSecond());
                } else {
                    if (line.matches("\"#.+?\"\\s*?:\\s*?((\".*?\")|(null)),?")) {
                        if (jsonStructure.peek().equals(parser.extractName(line).substring(1))) {
                            builder.setValue(parser.getValue(line));
                        } else {
                            builder.createSingleElement(
                                    parser.extractName(line).substring(1),
                                    parser.getValue(line),
                                    jsonStructure);
                            builder.stripAttributes();
                        }

                    } else {
                        String[] elem = parser.getElement(line);
                        builder.createSingleElement(elem[0], elem[1], jsonStructure);
                    }
                }
            }
        }

        builder.print();

        List<PseudoElement> requests = builder.result();
        jsonStructure.clear();
        builder = new XMLBuilder(false);

//        requests.forEach(System.out::println);

        for (PseudoElement request : requests) {
            if (request.isGoUp()) {
                builder.createEnd(jsonStructure.peek(), jsonStructure.size());
                jsonStructure.pop();
            } else if (request.isParent()) {
                builder.addContainer(request.getName(), request.getAttributes(),
                        jsonStructure.size());
                jsonStructure.push(request.getName());
            } else {
                builder.createSingleElement(request.getName(),
                        request.getValue(), request.getAttributes(),
                        jsonStructure.size());
            }
        }

        builder.getResult();
    }

    public XMLDirector(String content) {
        this.content = content;
    }

    private String insertCharAt(String string, int character) {
        return string.substring(0, character) +
                "\n" + string.substring(character);
    }

    private List<String> beatifyJSON(String json) {
        Pattern pattern = Pattern.compile("(\"|false|true|null|\\d)(?=\\s*?[}\\]])|(\\s*?,|[}\\]](?!,))|\\[|\\{(?=\\s*?\")");
        Matcher matcher = pattern.matcher(json);
        List<Integer> newlineChars = new ArrayList<>();

        while (matcher.find()) {
            newlineChars.add(matcher.end());
        }

        for (int i = 0; i < newlineChars.size(); i++) {
            json = insertCharAt(json, newlineChars.get(i) + i);
        }

        List<String> lines = new ArrayList<>(Arrays.asList(json.split("\n")));
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).trim());
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i).trim().equals("}") && lines.get(i + 1).trim().equals(",")) {
                String brace = lines.get(i);
                String dot = lines.get(i + 1);
                brace = brace.concat(dot);
                lines.set(i, brace);
                lines.remove(i + 1);
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).matches("(?:\\s*?\".+?\"\\s*?:\\s*?\\[)|(?:\\s*?\\[)")) {
                arrays.push("array");
                lines.set(i, lines.get(i).replace("[", "{"));
            }

            if (arrays.size() > 0 &&
                    lines.get(i)
                            .matches("(?:null|true|false|-?\\d+(?:\\.\\d+)?|\\[|(?<!:)\\s*?\".*?\"|\\s*?\\{|(?:\\s*?[\\[{]\\s*?[\\]}]))\\s*?,?")) {
                if (!lines.get(i).matches("\".+?\"\\s*?:\\s*?.+")) {
                    String newLine = "\"element\":".concat(lines.get(i));
                    lines.set(i, newLine);
                }
            }

            if (lines.get(i).matches("\\s*?],?")) {
                //System.out.println(lines.get(i));
                arrays.pop();
                lines.set(i, lines.get(i).replace("]", "}"));
            }
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i).matches("\\s*?\"@.+?\"\\s*?:\\s*?\\{")
                    && lines.get(i + 1).matches("\\s*?},?")) {
                String newAttr = lines.get(i).replace("{", "\"\"");
                lines.set(i, newAttr);
                lines.remove(i + 1);
            }
        }


        return lines;
    }

    public void startConversion() {
        content = content.replaceAll("\\r\\n|\\r|\\n|\\t", " ");
        content = content.trim().substring(1, content.length() - 1).trim();
        parseElement(beatifyJSON(content));
    }
}
