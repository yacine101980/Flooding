package model;

import javafx.scene.paint.Color;

import java.util.List;

public class GreedyStrategy implements PlayStrategy{
    private final List<Color> availableColors;

    public GreedyStrategy(List<Color> availableColors) {
        this.availableColors = availableColors;
    }

    @Override
    public Color play(Cell startCell) {
        ColoredCellIterator cl = new ColoredCellIterator(startCell);
        int max = 0;
        int newMax = 0;
        int maxIndex = 0;
        for (int i = 0; i < availableColors.size(); i++) {
            if (newMax > max) {
                max = newMax;
                max = i;
            }
            for (int j = 0; j < cl.pendingCells.size(); j++) {
                if (availableColors.get(i).equals(cl.pendingCells.stream().toList().get(i).getColor())) {
                    newMax++;
                }
            }
        }
        return availableColors.get(maxIndex);
    }
}
