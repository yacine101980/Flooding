package model;

import javafx.scene.paint.Color;

import java.util.List;

public class GreedyStrategy implements PlayStrategy{
    private final List<Color> availableColors;
    private int max = 0;
    private int newMax = 0;
    private int maxIndex = 0;

    public GreedyStrategy(List<Color> availableColors) {
        this.availableColors = availableColors;
    }

    @Override
    public Color play(Cell startCell) {
        ColoredCellIterator coloredCellIterator = new ColoredCellIterator(startCell);
        for (int i = 0; i < availableColors.size(); i++) {
            if (newMax > max) {
                max = newMax;
                maxIndex = i;
            }
            for (int j = 0; j < coloredCellIterator.pendingCells.size(); j++) {
                if (availableColors.get(i).equals(coloredCellIterator.pendingCells.stream().toList().get(j).getColor())) {
                    newMax++;
                }
            }
        }
        return availableColors.get(maxIndex);
    }
}
