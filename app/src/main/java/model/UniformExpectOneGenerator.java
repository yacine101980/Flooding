package model;

import javafx.scene.paint.Color;

public class UniformExpectOneGenerator  implements ColorGenerator {
    private final Color uniformColor;
    private final Color exceptionColor;
    private int i = 0;

    public UniformExpectOneGenerator(Color uniformColor, Color exceptionColor) {
        this.uniformColor = uniformColor;
        this.exceptionColor = exceptionColor;
    }

    @Override
    public Color nextColor(Cell cell) {
        i++;
        if (i != 1) {return uniformColor;}
        return exceptionColor;
    }
}
