package model;

import javafx.scene.paint.Color;

import java.util.List;

public class CyclicStrategy implements PlayStrategy{
    private final List<Color> colors;
    private int index = 0;

    public CyclicStrategy(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public Color play(Cell startCell) {
        index++;
        return colors.get((index-1) % colors.size());
    }
}
