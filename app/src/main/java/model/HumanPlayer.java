package model;

public class HumanPlayer implements Player {
    private String name;
    private final Cell startCell;

    public HumanPlayer(String name, Cell startCell) {
        this.name = name;
        this.startCell = startCell;
    }
    public HumanPlayer(Cell startCell) {
        this.name = "Player";
        this.startCell = startCell;
    }
    @Override
    public void setName(String name) {this.name = name;}

    @Override
    public String getName() {return this.name;}

    @Override
    public Cell getStartCell() {return this.startCell;}

    @Override
    public boolean isHuman() {
        return true;
    }
}
