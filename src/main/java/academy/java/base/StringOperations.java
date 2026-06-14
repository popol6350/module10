package academy.java.base;

import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int total = 0;
        for (String s : strings) total += s.length();
        return total;
    }

    public static String getFirstAndLastLetterString(String string) {
        return "" + string.charAt(0) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int minLen = Math.min(string1.length(), string2.length());
        int i = 0;
        while (i < minLen && string1.charAt(i) == string2.charAt(i)) i++;
        return string1.substring(0, i);
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        String lower = string.toLowerCase();
        return lower.equals(reverse(lower));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longest = "";
        for (String s : strings) {
            if (isPalindromeIgnoreCase(s) && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index + length > string1.length() || index + length > string2.length()) return false;
        return string1.substring(index, index + length).equals(string2.substring(index, index + length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                         String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1)
                      .equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                      String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1)
                      .equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String cleaned = string.replace(" ", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringJoiner sj = new StringJoiner(",");
        for (int v : array) sj.add(String.valueOf(v));
        return sj.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringJoiner sj = new StringJoiner(",");
        for (double v : array) sj.add(String.format("%.2f", v));
        return sj.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder result = new StringBuilder();
        int pi = 0;
        for (int i = 0; i < string.length(); i++) {
            if (pi < positions.length && positions[pi] == i) {
                pi++;
            } else {
                result.append(string.charAt(i));
            }
        }
        return result;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        // positions are indices in the ORIGINAL string, sorted non-decreasing
        // We need to insert characters[i] at positions[i] in the original string
        // Multiple inserts at same position: inserted in order they appear
        StringBuilder result = new StringBuilder();
        int pi = 0;
        for (int i = 0; i <= string.length(); i++) {
            // Insert all characters whose original position == i
            while (pi < positions.length && positions[pi] == i) {
                result.append(characters[pi]);
                pi++;
            }
            if (i < string.length()) {
                result.append(string.charAt(i));
            }
        }
        return result;
    }
}
