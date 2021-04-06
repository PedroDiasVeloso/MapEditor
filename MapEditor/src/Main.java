import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Field field = new Field(20, 20);
        Position position = new Position(0, 0, field);
        Player player = new Player(field, position);
        FileLoading fileLoading = new FileLoading(field);
        Controller controller = new Controller(player, field,fileLoading);
        controller.init();
        player.init();


    }
}

