public class Day6 {

    public static void main(String[] args) {
        int marker = 0;
        int quantity = 0;

        try {
            marker = getMarker(args[0], Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException AIOOBE) {
            System.out.println("Please enter the code to be examined as the first argument and the distinct chars as the second one, when calling this application,\ne.g. 'java TuningTrouble abcdefg 4'.");
            System.exit(-1);
        } catch (NumberFormatException NFE) {
            System.out.println("Error: the second argument has to be an integer!");
            System.exit(-1);
        }

        if (marker >= 0) {
            System.out.println("First marker after character " + (marker));
        } else {
            System.out.println("No marker found!");
        }
    }

    static int getMarker(String code, int quantity) {
        for (int position = 0; position < code.length() - quantity - 1; position++) {
            String quantityChars = getCharRange(code, position, quantity);
            if (allCharsAreUnique(quantityChars, quantity) == true) {
                return (position + quantity);
            }
        }
        return -1;
    }

    static String getCharRange(String code, int position, int quantity) {
        if (position + quantity <= code.length()) {
            return code.substring(position, position + quantity);
        } else {
            return "";
        }
    }

    static boolean allCharsAreUnique(String chars, int quantity) {
        for (int i = 0; i <= quantity - 2; i++) {
            for (int j = i + 1; j <= quantity - 1; j++) {
                if (chars.charAt(i) == chars.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}