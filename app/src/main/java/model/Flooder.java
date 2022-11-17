package model;

import javafx.scene.paint.Color;

public class Flooder {
    public static void flood(Cell startCell, Color floodingColor) {
        ColoredCellIterator myCell = new ColoredCellIterator(startCell);
        while  (myCell.hasNext()) {
            myCell.next().setColor(floodingColor);
        }
    }

    public static int coloredArea(Cell startCell) {
        ColoredCellIterator myCell = new ColoredCellIterator(startCell);
        int CellsColored = 0;
        while (myCell.hasNext()) {
            myCell.next();
            CellsColored++;
        }
        return CellsColored;
    }

}
