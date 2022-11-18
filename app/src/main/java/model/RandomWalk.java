package model;

import javafx.scene.paint.Color;

import java.util.List;

public class RandomWalk implements PlayStrategy {
    public RandomWalk() {}
    @Override
    public Color play(Cell startCell) {
        ColoredCellIterator coloredCellIterator = new ColoredCellIterator(startCell);
        Cell cell = util.SetUtil.anyElement(coloredCellIterator.pendingCells);
        List<Cell> neighbours = cell.getNeighbours();
        return cell.getColor();
    }
}
