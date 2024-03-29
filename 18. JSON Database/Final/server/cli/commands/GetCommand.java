package server.cli.commands;

import com.google.gson.JsonElement;
import server.database.Database;

import javax.xml.crypto.Data;

public class GetCommand implements Command {

    private final JsonElement key;
    private JsonElement result;

    public GetCommand(JsonElement key) {
        this.key = key;
    }

    public final JsonElement getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = Database.INSTANCE.get(key);
    }
}
