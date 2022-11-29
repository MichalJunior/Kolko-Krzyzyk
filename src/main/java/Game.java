import model.Sign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {

        List<Sign> listSigns = new ArrayList<>();
        try {
            Moving.play(listSigns);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


