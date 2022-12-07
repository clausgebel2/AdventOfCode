package Year2022.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RucksackReorganization2 {
    public static void main(String[] args) {
        System.out.println();

        List<String> backpacks;
        backpacks = readLines("Year2022/Day03/rucksacks.txt");
        int priorityCounter = 0;

        List<String> firstBackpackLine = new ArrayList<>();
        List<String> secondBackpackLine = new ArrayList<>();
        List<String> thirdBackpackLine = new ArrayList<>();

        for (int i = 0; i <= backpacks.size() - 1; i = i + 3) {
            firstBackpackLine.add(backpacks.get(i));
            secondBackpackLine.add(backpacks.get(i + 1));
            thirdBackpackLine.add(backpacks.get(i + 2));
        }

        for (int i=0; i < firstBackpackLine.size(); i++) {
            priorityCounter += getPriorityOfCharGroup(firstBackpackLine, secondBackpackLine, thirdBackpackLine, i);
        }

        System.out.println("\nThe sum of all priorities is: " + priorityCounter);
    }

    static int getPriorityOfCharGroup(List<String> firstBackpacks, List<String> secondBackpacks, List<String> thirdBackpacks, int index) {
        for (char i=97; i<=122; i++) {
            if (firstBackpacks.get(index).indexOf(i) != -1 && secondBackpacks.get(index).indexOf(i) != -1 && thirdBackpacks.get(index).indexOf(i) != -1) {
                return i - 96;
            }
        }

        for (char i=65; i<=90; i++) {
            if (firstBackpacks.get(index).indexOf(i) != -1 && secondBackpacks.get(index).indexOf(i) != -1 && thirdBackpacks.get(index).indexOf(i) != -1) {
                return i - 38;
            }
        }
        return 0;
    }

    static ArrayList<String> readLines(String path) {
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