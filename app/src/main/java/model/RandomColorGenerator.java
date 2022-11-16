package model;

import javafx.scene.paint.Color;
import util.RandomUtil;

import java.util.List;
import java.util.Random;

public class RandomColorGenerator implements ColorGenerator {
    private final List<Color> colors;
    private final Random randomGenerator;


    public RandomColorGenerator(List<Color> colors, Random randomGenerator) {
        this.colors = colors;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Color nextColor(Cell cell) {
        return RandomUtil.randomElement(colors, randomGenerator);
    }
}
