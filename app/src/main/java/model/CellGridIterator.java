package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CellGridIterator implements Iterator<Cell> {
    private final ArrayGrid grid;
    private int indexRowPro;
    private int indexColumnPro;

    public CellGridIterator(ArrayGrid grid) {
        this.grid = grid;
        this.indexRowPro = 0;
        this.indexColumnPro = 0;
    }

    @Override
    public boolean hasNext() {return !(this.grid.getNumberOfRows() == this.indexRowPro && this.indexColumnPro == 0);}

    public Cell next() {
        Cell cell = this.grid.getCell(indexRowPro,indexColumnPro);
        int rowPro = this.indexRowPro;
        int columnPro= this.indexColumnPro;

        if (columnPro == this.grid.getNumberOfColumns() -1){
            this.indexRowPro++;
            this.indexColumnPro=0;
        }
        else{
            this.indexColumnPro++;
        }
        if(rowPro== this.grid.getNumberOfRows()){
            throw new NoSuchElementException();
        }
        return cell;
    }


}
