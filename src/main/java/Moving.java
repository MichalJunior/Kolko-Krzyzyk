import model.Circle;
import model.Cross;
import model.Sign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Moving {
    public static void play(List<Sign> listSigns) throws IOException {
        fillEmptyBoard(listSigns);

        System.out.println("Welcome in game Circle and Cross");
        int round = 0;
        while (true) {
            System.out.println("1|2|3        " + listSigns.get(0).getName() + "|" + listSigns.get(1).getName() + "|" + listSigns.get(2).getName());
            System.out.println("4|5|6        -----");
            System.out.println("7|8|9        " + listSigns.get(3).getName() + "|" + listSigns.get(4).getName() + "|" + listSigns.get(5).getName());
            System.out.println("             -----");
            System.out.println("             " + listSigns.get(6).getName() + "|" + listSigns.get(7).getName() + "|" + listSigns.get(8).getName());

            Moving.makeMove(round, listSigns);
            List<String> solutions = new ArrayList<>();

            addSolutions(solutions);

            for (String solution : solutions) {
                if (listSigns.get(Integer.parseInt(solution.substring(0, 1))).getName().equals(listSigns.get(Integer.parseInt(solution.substring(1, 2))).getName()) &&
                        listSigns.get(Integer.parseInt(solution.substring(0, 1))).getName().equals(listSigns.get(Integer.parseInt(solution.substring(2))).getName()) &&
                        !listSigns.get(Integer.parseInt(solution.substring(0, 1))).getName().equals(" ") &&
                        !listSigns.get(Integer.parseInt(solution.substring(1, 2))).getName().equals(" ") &&
                        !listSigns.get(Integer.parseInt(solution.substring(2))).getName().equals(" ")) {
                    System.out.println("------------------------------------------------\n           ***  Player - " + listSigns.get(0).getName() + "-  WIN  ***  \n------------------------------------------------");
                    listSigns.clear();
                    play(listSigns);
                }
            }
            if (round == 8) {
                System.out.println("                    ---***   Nobody won   ***---");
                listSigns.clear();
                play(listSigns);
            }
            System.out.println("---------------------------------------------------------------------------+");
            round++;
        }
    }

    private static void addSolutions(List<String> solutions) {
        solutions.add("123");
        solutions.add("345");
        solutions.add("678");
        solutions.add("036");
        solutions.add("147");
        solutions.add("258");
        solutions.add("246");
        solutions.add("048");
    }

    public static void makeMove(int round, List<Sign> listSigns) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        if (round % 2 == 0) {
            System.out.print("Player -O- Insert your choice:");
            int firstPlayerChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
            if (listSigns.get(firstPlayerChoice).getName().equals(" ")) {
                listSigns.set(firstPlayerChoice, new Circle());
            } else {
                System.out.println("      ***    You can not assign CIRCLE there     ***    ");
                makeMove(round, listSigns);
            }
        } else {
            System.out.print("Player -X- Insert your choice:");
            int secondPlayerChoice = Integer.parseInt(bufferedReader.readLine()) - 1;
            if (listSigns.get(secondPlayerChoice).getName().equals(" ")) {
                listSigns.set(secondPlayerChoice, new Cross());
            } else {
                System.out.println("       ***    You can not assign CROSS there    ***   ");
                makeMove(round, listSigns);
            }
        }
    }

    public static void fillEmptyBoard(List<Sign> listSigns) {
        for (int i = 0; i < 9; i++) {
            listSigns.add(new Sign());
        }
    }
}