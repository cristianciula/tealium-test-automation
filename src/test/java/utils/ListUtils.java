package utils;

import java.util.Collections;
import java.util.List;

public final class ListUtils {

    public static List<String> sortAZ(List<String> list) {
        Collections.sort(list);
        return list;
    }
    public static List<String> sortZA(List<String> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
    public static List<Double> sortLowToHigh(List<Double> list) {
        Collections.sort(list);
        return list;
    }
    public static List<Double> sortHighToLow(List<Double> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}
