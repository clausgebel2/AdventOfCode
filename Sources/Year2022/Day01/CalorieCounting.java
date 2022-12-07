package Year2022.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CalorieCounting {
    public static void main(String[] args) {
        String pathname = "Year2022/Day01/calories.txt";
        ArrayList<String> calories = new ArrayList<>();
        ArrayList<Integer> addedUpCalories = new ArrayList<>();

        calories = readLines(pathname);
        addedUpCalories = addCaloriesUp(calories);

        int maxThreeCaloriesInTotal = 0;

        System.out.println("The winner is: " + Collections.max(addedUpCalories));
        maxThreeCaloriesInTotal = Collections.max(addedUpCalories);
        addedUpCalories.remove(Collections.max(addedUpCalories));

        System.out.println("Second place: " + Collections.max(addedUpCalories));
        maxThreeCaloriesInTotal += Collections.max(addedUpCalories);
        addedUpCalories.remove(Collections.max(addedUpCalories));

        System.out.println("Third place: " + Collections.max(addedUpCalories));
        maxThreeCaloriesInTotal += Collections.max(addedUpCalories);

        System.out.println("The sum of the largest three calories is: " + maxThreeCaloriesInTotal);

    }

    static ArrayList<Integer> addCaloriesUp(ArrayList<String> calories) {
        int counter = 0;
        ArrayList<Integer> addedUp = new ArrayList<>();
        for(String calorie: calories) {
            if (calorie.isEmpty()) {
                addedUp.add(counter);
                counter = 0;
            } else {
                counter += Integer.parseInt(calorie);
            }
        }

        //Check if last line is a number and not a blank line
        if (!calories.get(calories.size() - 1).isEmpty()) {
            addedUp.add(counter);
        }

        return addedUp;
    }

    static ArrayList<String> readLines(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException FNFE) {
            System.out.println("Error: file 'calories.txt' is needed.");
            System.exit(-1);
        }
        return lines;
    }
}
