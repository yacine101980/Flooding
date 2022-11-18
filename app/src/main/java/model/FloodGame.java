package model;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.Arrays;
import java.util.List;

import static model.Flooder.coloredArea;

public class FloodGame {

    private  Player player;
    private final int totalFloodingArea;
    private final SimpleIntegerProperty turn  = new SimpleIntegerProperty(0);

    public FloodGame(int totalFloodingArea){
        this.totalFloodingArea = totalFloodingArea;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void setTurn(int value){
        turn.setValue(value);
    }

    public int  getTurn(){
        return turn.getValue();
    }

    public void  resetTurn() {
        setTurn(0);
    }

    public SimpleIntegerProperty getTurnProperty(){
        return turn;
    }

    public void incrementTurn(){
        setTurn(getTurn()+1);
    }

    public boolean isHumanTurn(){
        return getPlayer().isHuman();
    }


    public int getPlayerScore(Player player) {return coloredArea(player.getStartCell());}

    public boolean hasWon(Player player){
        if (coloredArea(player.getStartCell()) == totalFloodingArea) {
            return true;
        }
        return false;
    }

    public boolean hasEnded(){return hasWon(this.player);}

}
