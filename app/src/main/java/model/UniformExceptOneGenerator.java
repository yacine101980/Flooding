package model;

import javafx.scene.paint.Color;

public class UniformExceptOneGenerator  implements ColorGenerator {
    private final Color uniformColor;
    private final Color exceptionColor;
    private int index = 0;

    public UniformExceptOneGenerator(Color uniformColor, Color exceptionColor) {
        this.uniformColor = uniformColor;
        this.exceptionColor = exceptionColor;
    }

    @Override
    public Color nextColor(Cell cell) {
        index++;
        if ((index-1) != 1) {return uniformColor;}
        return exceptionColor;
    }
}
