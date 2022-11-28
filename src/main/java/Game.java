import model.Circle;
import model.Cross;
import model.Sign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) throws IOException {
        List<Sign> listSigns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            listSigns.add(new Sign());

        }
        System.out.println("Welcome in game Circle and Cross");
        int round = 0;
        while (true) {

            System.out.println("1|2|3        " + listSigns.get(0).getName() + "|" + listSigns.get(1).getName() + "|" + listSigns.get(2).getName());
            System.out.println("4|5|6        -----");
            System.out.println("7|8|9        " + listSigns.get(3).getName() + "|" + listSigns.get(4).getName() + "|" + listSigns.get(5).getName());
            System.out.println("             -----");
            System.out.println("             " + listSigns.get(6).getName() + "|" + listSigns.get(7).getName() + "|" + listSigns.get(8).getName());


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            if (round % 2 != 0) {
                System.out.print("Player -O- Insert your choice:");
                int firstPlayerChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
                listSigns.set(firstPlayerChoice, new Circle());
            } else {
                System.out.print("Player -X- Insert your choice:");
                int secondPlayerChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
                listSigns.set(secondPlayerChoice, new Cross());
            }
            round++;
        }

    }
}
