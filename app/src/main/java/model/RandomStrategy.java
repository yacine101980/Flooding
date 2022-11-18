package model;

import javafx.scene.paint.Color;
import util.RandomUtil;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements PlayStrategy{
    private final List<Color> colors;
    private final Random random;

    public RandomStrategy(List<Color> colors, Random random) {
        this.colors = colors;
        this.random = random;
    }

    @Override
    public Color play(Cell startCell) {
        return RandomUtil.randomElement(colors, random);
    }
}
