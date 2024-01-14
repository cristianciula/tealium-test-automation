package utils;

public final class StringsUtils {

    public static String[] stringToArray(String input) {

        // Remove the square brackets and double quotes
        String cleanedInput = input.replaceAll("[\\[\\]\"]", "");

        // Split the cleaned string into an array using the comma as a delimiter
        String[] array = cleanedInput.split(",");

        return array;
    }

}
