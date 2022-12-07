package Year2022.Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CampCleanup {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>(readLines("pairs.txt"));
        int fullContainmentCounter = 0, containmentCounter = 0;

        for (String line: lines) {
            //String[] numberLine = new String[4];
            Pattern pattern = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (Integer.parseInt(matcher.group(1)) <= Integer.parseInt(matcher.group(3)) && Integer.parseInt(matcher.group(2)) >= Integer.parseInt(matcher.group(4)) ||
                        Integer.parseInt(matcher.group(1)) >= Integer.parseInt(matcher.group(3)) && Integer.parseInt(matcher.group(2)) <= Integer.parseInt(matcher.group(4))) {
                    fullContainmentCounter++;
                }

                if (getMax(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(3))) <= getMin(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(4)))) {
                    containmentCounter++;
                }
            }



        }
        System.out.println(fullContainmentCounter + " pair(s) fully contain(s) the other.");
        System.out.println(containmentCounter + " pair(s) contain(s) the other.");

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

    private static int getMax(int x, int y) {
        return (x > y ? x : y);
    }

    private static int getMin(int x, int y) {
        return (x < y ? x : y);
    }
}
