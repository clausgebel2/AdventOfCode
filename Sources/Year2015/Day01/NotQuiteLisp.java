package Year2015.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NotQuiteLisp {
    public static void main(String[] args)  {
        ArrayList<Character> storySymbols = new ArrayList<>(readLines("storyguide.txt"));
        int currentStory = 0, basementPosition = 0;

        // First part
        for (Character storySymbol: storySymbols) {
            if (storySymbol == '(')
                currentStory += 1;
            else if (storySymbol == ')')
                currentStory -= 1;
        }
        System.out.println("Santa, ye hafta goto de " + currentStory + ". floor!");

        // Second part
        currentStory = 0;
        for (Character storySymbol: storySymbols) {
            if (storySymbol == '(') {
                currentStory += 1;
            }
            else if (storySymbol == ')') {
                currentStory -= 1;
            }
            basementPosition++;
            if (currentStory == -1) {
                break;
            }
        }
        System.out.println("Santa, position of the basement is " + basementPosition + "!");

    }

    private static ArrayList<Character> readLines(String path) {
        String line = null;
        try {
            Scanner scanner = new Scanner(new File(path));

                line = scanner.nextLine();
        } catch (FileNotFoundException FNFE) {
            System.out.println("Error: file '" + path +"' is needed.");
            System.exit(-1);
        }

        ArrayList<Character> stories = new ArrayList<Character>();
        for (char storySymbol : line.toCharArray()) {
            stories.add(storySymbol);
        }
        return stories;
    }
}
