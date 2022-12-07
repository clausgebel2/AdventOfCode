package Year2022.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(readLines("Year2022/Day02/game.txt"));
        int counter = 0;

        System.out.println("Total score: " + getScore(lines));
        System.out.println("Total score, part 2: " + getScore2(lines));

    }

    private static int getScore(ArrayList<String> lines) {
        Map<String, Integer> score = new HashMap<>();
        int counter = 0;
        score.put("A X", 4);
        score.put("A Y", 8);
        score.put("A Z", 3);
        score.put("B X", 1);
        score.put("B Y", 5);
        score.put("B Z", 9);
        score.put("C X", 7);
        score.put("C Y", 2);
        score.put("C Z", 6);

        for (String line: lines) {
            if (score.containsKey(line.strip())){
                counter += score.get(line.strip());
            }
        }
        return counter;
    }

    private static int getScore2(ArrayList<String> lines) {
        Map<String, Integer> score = new HashMap<>();
        int counter = 0;
        score.put("A X", 3);
        score.put("A Y", 4);
        score.put("A Z", 8);
        score.put("B X", 1);
        score.put("B Y", 5);
        score.put("B Z", 9);
        score.put("C X", 2);
        score.put("C Y", 6);
        score.put("C Z", 7);

        for (String line: lines) {
            if (score.containsKey(line.strip())){
                counter += score.get(line.strip());
            }
        }
        return counter;
    }


    private static ArrayList<String> readLines(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException FNFE) {
            System.out.println("Error: file '" + path +"' is needed.");
            System.exit(-1);
        }
        return lines;
    }
}
