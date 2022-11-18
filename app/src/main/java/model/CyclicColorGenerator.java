package model;

import javafx.scene.paint.Color;
import java.util.List;

public class CyclicColorGenerator implements ColorGenerator {
    private int index = 0;
    private final List<Color> colors;

    public CyclicColorGenerator(List<Color> colors) {
        this.colors = colors;
    }


    @Override
    public Color nextColor(Cell cell) {
        index++;
        return colors.get((index-1) % colors.size());
    }
}
