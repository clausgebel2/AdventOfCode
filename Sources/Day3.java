import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        System.out.println();

        List<String> backpacks = new ArrayList<>();
        backpacks = readLines("rucksacks.txt");
        int priorityCounter = 0;

        List<String> leftCompartments = new ArrayList<>();
        List<String> rightCompartments = new ArrayList<>();

        leftCompartments = getCompContents(backpacks);
        rightCompartments = getCompContents(backpacks);

        for (int i=0; i< backpacks.size(); i++) {
            priorityCounter += getPriorityOfCharPairs(leftCompartments, rightCompartments, i);
        }

        System.out.println("\nThe sum of all priorities is: " + priorityCounter);
    }

    static int getPriorityOfCharPairs(List<String> leftComps, List<String> rightComps, int index) {
        String leftCompartment = leftComps.get(index);
        String rightCompartment = rightComps.get(index);

        for (char i=97; i<=122; i++) {
            if (leftCompartment.indexOf(i) != -1 && rightCompartment.indexOf(i) != -1) {
                return getPriority(i);
            }
        }

        for (char i=65; i<=90; i++) {
            if (leftCompartment.indexOf(i) != -1 && rightCompartment.indexOf(i) != -1) {
                return getPriority(i);
            }
        }
        return -1;
    }

    static int getPriority(char character){
        int position = character;
        // Lowercase
        if (position >= 97 && position <= 122) {
            return (position - 96);
        } else { // Uppercase
            return (position -  38);
        }
    }

    static List<String> getCompContents(List<String> contents) {
        List<String> containers = new ArrayList<>();
        for (String content: contents) {
            int length = content.length();
            containers.add(content.substring(0, length / 2));
        }
        return containers;
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
