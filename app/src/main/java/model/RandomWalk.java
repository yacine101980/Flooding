package model;

import javafx.scene.paint.Color;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWalk implements PlayStrategy {
    private final List<Color> availableColors;

    public RandomWalk(List<Color> availableColors) {
        this.availableColors = availableColors;
    }

    @Override
    public Color play(Cell startCell) {
        ColoredCellIterator coloredCellIterator = new ColoredCellIterator(startCell);
        List<Color> availableColors = new ArrayList<>();
        Random random = new Random();
        List<PlayStrategy> list = new ArrayList<>();
        list.add(new CyclicStrategy(availableColors));
        list.add(new RandomStrategy(availableColors, random));
        while (coloredCellIterator.hasNext()) {
            for (Cell cell : coloredCellIterator.next().getNeighbours()) {
                if (cell.getColor() != startCell.getColor()) {
                    availableColors.add(cell.getColor());
                }
            }
        }
        return RandomUtil.randomElement(list, random).play(startCell);
    }
}
