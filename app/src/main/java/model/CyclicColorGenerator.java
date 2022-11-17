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
        if ((i-1) == colors.size()) {i = 1;}
        return colors.get(i-1);
    }
}
