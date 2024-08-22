package utils;

import java.util.Random;

public final class RandomUtils {

    public static int intValue(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public static String alphabeticalString(int numOfChars) {
        String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (numOfChars-- != 0) {
            int character = (int)(Math.random()*CHARACTER_STRING.length());
            builder.append(CHARACTER_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String alphanumericalString(int numOfChars) {
        String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        while (numOfChars-- != 0) {
            int character = (int)(Math.random()*CHARACTER_STRING.length());
            builder.append(CHARACTER_STRING.charAt(character));
        }
        return builder.toString();
    }

}
