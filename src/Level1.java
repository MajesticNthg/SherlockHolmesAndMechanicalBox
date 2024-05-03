import java.util.*;

public class Level1 {
    public static boolean SherlockValidString(String s) {
        StringBuilder letter = new StringBuilder(s);

        for (int x = 0; x < letter.length(); x++) {
            for (int y = x + 1; y < letter.length(); y++) {
                if (letter.charAt(x) == letter.charAt(y)) {
                    letter.deleteCharAt(y);
                    y--;
                }
            }
        }

        char[] ca = new char[letter.length()];
        for (int x = 0; x < ca.length; x++) {
            ca[x] = '0';
            for (int y = 0; y < s.length(); y++) {
                if (letter.charAt(x) == s.charAt(y)) {
                    ca[x] += 1;
                }
            }
        }

        boolean output = validity(ca);
        return output;
    }

    public static boolean validity(char[] ca) {
        char[] copy = new char[ca.length];
        System.arraycopy(ca, 0, copy, 0, ca.length);
        Arrays.sort(copy);
        int f = 0;
        int min = Character.getNumericValue(copy[0]);
        int h = 0;

        for (int g = 0; g < copy.length; g++) {
            int z = Character.getNumericValue(copy[g]) - min;
            if (z != h && g == 1 && copy[0] == '1') {
                f++;
                h = z;
            }
            if (z != h && z > 1 && g >= 1) return false;
            if (z != h && g > 1) f++;
            if (f >= 2) return false;
        }

        return true;
    }
}

