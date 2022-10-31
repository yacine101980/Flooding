package controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.*;
import view.MatrixPane;

import java.util.List;
import java.util.Random;

public class GameController {
    public static final Color COLOR_ONE   = Color.RED;
    public static final Color COLOR_TWO   = Color.BLUE;
    public static final Color COLOR_THREE = Color.YELLOW;
    public static final Color COLOR_FOUR  = Color.GREEN;
    private static final List<Color> availableColors = List.of(COLOR_ONE, COLOR_TWO, COLOR_THREE, COLOR_FOUR);

    public static final double PAUSE_MILLISECONDS = 400;
    private final PauseTransition pause = new PauseTransition(Duration.millis(PAUSE_MILLISECONDS));

    private final Random random = new Random();

    @FXML
    MatrixPane matrixPane;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label tourLabel;

    private FloodGame game;


    public void initialize(){
        this.game = new FloodGame(
                matrixPane.getGrid().getNumberOfColumns()  * matrixPane.getGrid().getNumberOfRows());
        setPlayerHuman();
        matrixPane.setGameController(this);
        setScoreLabelTextProperty();
        setTourLabelTextProperty();
        addTurnListener();
        setPauseAnimation();
    }



    private void addTurnListener(){
        game.getTurnProperty().addListener((observable, oldValue, newValue) -> playComputerTurn());
    }



    private void colorGrid(ColorGenerator colorGenerator){
        // TODO
        //  matrixPane.getGrid().color(colorGenerator);
    }


    @FXML
    public void fillGridUniform() {
        // TODO uncomment:
        //  colorGrid(new UniformColorGenerator(COLOR_ONE));
    }

    @FXML
    public void fillGridRandom() {
        // TODO uncomment
        //  colorGrid(new RandomColorGenerator(availableColors,random));
    }

    @FXML
    public void fillGridDistinct() {
        // TODO uncomment
        //  fillGridUniform();
        //  colorGrid(new DistinctColorGenerator(COLOR_ONE,List.of(COLOR_THREE, COLOR_FOUR)));
    }

    @FXML
    public void fillGridCycle() {
        // TODO uncomment
        //  colorGrid(new CyclingColorGenerator(availableColors));
    }

    @FXML
    public void fillGridUniformExceptOne() {
        // TODO uncomment
        //  colorGrid(new UniformExceptOneColorGenerator(COLOR_ONE,COLOR_TWO));
    }

    private void playComputerTurn(){
        // TODO
        //  uncomment
        // if (!game.hasEnded() && !game.isHumanTurn()){
        //    ComputerPlayer player = ((ComputerPlayer) game.getPlayer());
        //    Flooder.flood(player.getStartCell(), player.play());
        //    setScoreLabelTextProperty();
        //    pause.play();
        // }
    }

    public void playHumanTurn(Color color){
        // TODO
        //  uncomment
        // if(!game.hasEnded() && game.isHumanTurn()){
        //     Flooder.flood(game.getPlayer().getStartCell(), color);
        //    setScoreLabelTextProperty();
        //    game.incrementTurn();
        //}
    }

    private void setPauseAnimation(){
        pause.setOnFinished(e -> game.incrementTurn());
    }

    private void setTourLabelTextProperty() {
        tourLabel.textProperty().bind(game.getTurnProperty().asString());
    }

    private void setScoreLabelTextProperty() {
        // TODO
        //  uncomment
        //  Player player = game.getPlayer();
        //  scoreLabel.textProperty().setValue(Integer.toString(game.getPlayerScore(player)));
    }


    @FXML
    public void startGame(){
        if(game.getTurn() != 0)  game.resetTurn();
        setScoreLabelTextProperty();
        playComputerTurn();
    }


    private Cell getGridStartCell(){
        return matrixPane.getGrid().getCell(0,0);
    }



    @FXML
    public void setPlayerHuman(){
        // TODO
        //  game.setPlayer(new HumanPlayer("human", getGridStartCell()));
    }

    @FXML
    public void setPlayerRandom() {
        // TODO
        //  Player player = ... instantiate  a ComputerPlayer named "random" that follows the random strategy
        //  game.setPlayer(player);
    }
    @FXML
    public void setPlayerRobin() {
        // TODO
        //  Player player = ... instantiate a ComputerPlayer named "cyclic" that follows the cyclic strategy
        //  game.setPlayer(player);
    }

    @FXML
    public void setPlayerRandomWalk() {
        // TODO
        //  Player player = ... instantiate a ComputerPlayer named "walker" that follows the random walk strategy
        //  game.setPlayer(player);
    }

    @FXML
    public void setPlayerGreedy() {
        // TODO
        //  Player player = ... instantiate a ComputerPlayer named "greedy" that follows the greedy strategy
        //  game.setPlayer(player);
    }

}
