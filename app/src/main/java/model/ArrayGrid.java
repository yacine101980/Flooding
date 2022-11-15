package model;

import java.util.List;
import java.util.ArrayList;

public class ArrayGrid implements Grid{

    public Cell[][] cells;
    private int numberOfRows;
    private int numberOfColumns;

    public ArrayGrid(int numberOfRows, int numberOfColumns) {
        if ((numberOfRows <= 0) || (numberOfColumns <= 0)) {throw new IllegalArgumentException();}
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        cells = new Cell[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = new SquareCell();
            }
        }
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                calculateNeighbours(i,j);
            }
        }
    }

    private void calculateNeighbours(int indexRow, int indexColumn) {
        List<Cell> neighbours = new ArrayList<>();

        if(indexRow > 0){ neighbours.add(getCell(indexRow - 1, indexColumn)); }
        if(indexColumn > 0){ neighbours.add(getCell(indexRow, indexColumn - 1)); }
        if(indexRow + 1 < getNumberOfRows()){ neighbours.add(getCell(indexRow + 1, indexColumn)); }
        if(indexColumn + 1 < getNumberOfColumns()){ neighbours.add(getCell(indexRow, indexColumn + 1)); }


        getCell(indexRow,indexColumn).setNeighbours(neighbours);
    }

    @Override
    public Cell getCell(int row, int column) {return cells[row][column];}

    @Override
    public int getNumberOfColumns() {return this.numberOfColumns;}

    @Override
    public int getNumberOfRows() {return this.numberOfRows;}
}
