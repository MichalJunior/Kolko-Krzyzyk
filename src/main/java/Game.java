import model.Sign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) throws IOException {

        List<Sign> listSigns = new ArrayList<>();
       Moving.play(listSigns);
    }
}


