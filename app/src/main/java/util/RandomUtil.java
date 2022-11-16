package util;

import java.util.Random;
import java.util.List;

public class RandomUtil {

    private RandomUtil(){}

    public static <T> T randomElement(T[] elements, Random random) {
        return elements[random.nextInt(elements.length)];
    }

    public static <T> T randomElement(List<T> elements, Random random) {
        return elements.get(random.nextInt(elements.size()));
    }

}
