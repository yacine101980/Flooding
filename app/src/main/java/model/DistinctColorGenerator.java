package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class DistinctColorGenerator implements ColorGenerator {
    private final List<Color> colors;
    private final Color defaultColor;

    public DistinctColorGenerator(List<Color> colors, Color defaultColor) {
        this.colors = colors;
        this.defaultColor = defaultColor;
    }

    @Override
    public Color nextColor(Cell cell) {
        List<Color> neighboursColors = new ArrayList<>();
        for (Cell neighbour : cell.getNeighbours()) {
            neighboursColors.add(neighbour.getColor());
        }

        for (Color color : colors) {
            if (!(neighboursColors.contains(color))) {
                return color;
            }
        }
        return defaultColor;
    }
}
