package model;

import javafx.scene.paint.Color;
import util.SetUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class ColoredCellIterator implements Iterator<Cell> {
    private final Color color;
    public Set<Cell> visitedCells;
    public Set<Cell> pendingCells;

    public ColoredCellIterator(Cell startCell) {
        this.color = startCell.getColor();
        this.pendingCells = new HashSet<>();
        this.visitedCells = new HashSet<>();
        this.pendingCells.add(startCell);
    }


    @Override
    public boolean hasNext() {
        return !(this.pendingCells.isEmpty());
    }

    @Override
    public Cell next() {
        Cell newCell = SetUtil.anyElement(this.pendingCells);
        this.pendingCells.remove(newCell);
        this.visitedCells.add(newCell);
        for (Cell neighbour : newCell.getNeighbours()){
            if (newCell.getColor() == neighbour.getColor() && !(this.visitedCells.contains(neighbour))){
                this.pendingCells.add(neighbour);
            }
        }
        return newCell;
    }
}
