package utils;

public final class StringUtils {

    public static String[] stringToArray(String input) {

        // Remove the square brackets and double quotes
        String cleanedInput = input.replaceAll("[\\[\\]\"]", "");

        // Return the cleaned string as an array by adding the comma as a delimiter
        return cleanedInput.split(",");
    }
}
