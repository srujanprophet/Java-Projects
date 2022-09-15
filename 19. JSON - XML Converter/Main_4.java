// 4. Parsing JSON

package converter;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var json = Files.readString(Path.of("test.txt"))
                .replace(",", "~").replaceAll("\\{", "~{~").replaceAll("\\s*}", "~}~").split("~");

        for (int index = 0; index < json.length; index++) {
            if (json[index].matches("\\{") && json[index + 1].contains("@")) {
                var firstChild = new HashMap<String, Integer>();
                var secondChild = new HashMap<String, Integer>();
                for (int i = index + 1; !json[i].matches("}"); i++) {
                    if (json[i].matches("[@#]")) firstChild.put(json[i].split(":")[0], i);
                    if (!json[i].matches("[{}]")) secondChild.put(json[i].split(":")[0], i);
                    firstChild.entrySet().stream()
                            .filter(e -> secondChild.entrySet().stream().anyMatch(s -> e.getKey().matches(s.getKey())))
                            .forEach(e -> json[e.getValue()] = "");
                }
            }
        }
        for (int index = 0; index < json.length; index++) {
            if (json[index].matches("}")) {
                int total = 0, internal = 0;
                for (int i = index - 1; ; i--) {
                    if (json[i].matches("(@[^\"]+)|#")) internal++;
                    else if (json[i].matches("\\{") && total != internal) {
                        for (int s = index - 1; !json[s].matches("\\{"); s--) {
                            json[s] = json[s].replaceAll("[@#]", "");
                            if (json[s].split(":")[0].length() == 2) json[s] = "";
                        }
                        break;
                    }
                    total++;
                }
            }
        }
        var paths = new ArrayDeque<String>();
        for (int index = 0; index < json.length; index++) {
            if (!paths.isEmpty() && json[index].matches("}")) paths.removeLast();
            else if (json[index].contains("#") && index - 1 > 0) json[index] = json[index].replace("#", "");
            else if (json[index].matches("\\s*\"[^@#]+\":.+")) {
                var path = json[index].replace(":", "").replaceAll("\\s", "");
                if (path.matches("\"[^@#\"]+\"")) paths.add(path.replace("\"", ""));
                if (json[index + 1].matches("\\{")) {
                    if (json[index + 2].matches("[@#].+")) {
                        for (int i = index + 2; json[i].contains("@"); i++) {
                            print(String.format("%s = \n", json[i].split(":")[0]), paths, json[i].split(":")[1]);
                        }
                    } else print("", paths, "");
                } else {
                    var split = json[index].split("\\s*:\\s*");
                    paths.add(split[0].replace(":", "").replaceAll("\\s", "").replace("\"", ""));
                    print("", paths, "null".equals(split[1]) ? "null" : "\"" + split[1].replaceAll("\"", "") + "\"");
                    paths.removeLast();
                }
            }
        }
    }

    static void print(String attributes, Deque<String> path, String value) {
        System.out.printf("Element:\npath = %s\n%s\n%s\n",
                path.isEmpty() ? "" : String.join(", ", path),
                value.isBlank() ? "" : "value = " + value,
                attributes.isBlank() ? "" : "attributes:\n" + attributes);
    }
}
