package model;

import javafx.scene.paint.Color;

public class ComputerPlayer implements Player {
    private String name;
    private final Cell startCell;
    private PlayStrategy playStrategy;

    public ComputerPlayer(String name, Cell startCell) {
        this.name = name;
        this.startCell = startCell;
    }

    public ComputerPlayer(String name, Cell startCell, PlayStrategy playStrategy) {
        this.name = name;
        this.startCell = startCell;
        this.playStrategy = playStrategy;
    }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Cell getStartCell() {
        return this.startCell;
    }

    @Override
    public boolean isHuman() {
        return false;
    }
    public void setPlayStrategy(PlayStrategy playStrategy) { this.playStrategy = playStrategy; }

    public Color play() {
        return this.playStrategy.play(startCell);
    }
}
