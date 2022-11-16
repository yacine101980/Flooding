package model;

import javafx.scene.paint.Color;
import java.util.List;

public class CyclicColorGenerator implements ColorGenerator {
    private int i = 0;
    private final List<Color> colors;

    public CyclicColorGenerator(List<Color> colors) {
        this.colors = colors;
    }


    @Override
    public Color nextColor(Cell cell) {
        i++;
        if (i == colors.size()) {i = 0;}
        return colors.get(i);
    }
}
