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
    public static final Color COLOR_FIRST_NAME_ONE = Color.YELLOW;
    public static final Color COLOR_LAST_NAME_ONE = Color.BLUE;
    public static final Color COLOR_FIRST_NAME_TWO = Color.ALICEBLUE;
    public static final Color COLOR_LAST_NAME_TWO = Color.OLDLACE;
    private static final List<Color> availableColors = List.of(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, COLOR_FIRST_NAME_TWO, COLOR_LAST_NAME_TWO);

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
        matrixPane.getGrid().color(colorGenerator);
    }


    @FXML
    public void fillGridUniform() {
        colorGrid(new UniformColorGenerator(COLOR_FIRST_NAME_ONE));
    }

    @FXML
    public void fillGridRandom() {
        colorGrid(new RandomColorGenerator(availableColors,random));
    }

    @FXML
    public void fillGridDistinct() {
        fillGridUniform();
        colorGrid(new DistinctColorGenerator(List.of(COLOR_FIRST_NAME_TWO, COLOR_LAST_NAME_TWO),COLOR_FIRST_NAME_ONE));
    }

    @FXML
    public void fillGridCycle() {
        colorGrid(new CyclicColorGenerator(availableColors));
    }

    @FXML
    public void fillGridUniformExceptOne() {
        colorGrid(new UniformExceptOneGenerator(COLOR_FIRST_NAME_ONE,COLOR_LAST_NAME_ONE));
    }

    private void playComputerTurn(){
        if (!game.hasEnded() && !game.isHumanTurn()){
            ComputerPlayer player = ((ComputerPlayer) game.getPlayer());
            Flooder.flood(player.getStartCell(), player.play());
            setScoreLabelTextProperty();
            pause.play();
        }
    }

    public void playHumanTurn(Color color){
        if(!game.hasEnded() && game.isHumanTurn()){
            Flooder.flood(game.getPlayer().getStartCell(), color);
            setScoreLabelTextProperty();
            game.incrementTurn();
        }
    }

    private void setPauseAnimation(){
        pause.setOnFinished(e -> game.incrementTurn());
    }

    private void setTourLabelTextProperty() {
        tourLabel.textProperty().bind(game.getTurnProperty().asString());
    }

    private void setScoreLabelTextProperty() {
        Player player = game.getPlayer();
        scoreLabel.textProperty().setValue(Integer.toString(game.getPlayerScore(player)));
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
        game.setPlayer(new HumanPlayer("human", getGridStartCell()));
    }

    @FXML
    public void setPlayerRandom() {
        Player player = new ComputerPlayer("random", matrixPane.getGrid().getCell(0, 0), new RandomStrategy(availableColors, random));
        game.setPlayer(player);
    }
    public void setPlayerCyclic() {
        Player player = new ComputerPlayer("cyclic", matrixPane.getGrid().getCell(0, 0), new CyclicStrategy(availableColors));
        game.setPlayer(player);
    }
    @FXML
    public void setPlayerRobin() {
        Player player = new ComputerPlayer("cyclic", matrixPane.getGrid().getCell(0, 0), new RobinStrategy(availableColors));
        game.setPlayer(player);
    }

    @FXML
    public void setPlayerRandomWalk() {
        Player player = new ComputerPlayer("walker", matrixPane.getGrid().getCell(0, 0), new RandomWalk());
        game.setPlayer(player);
    }

    @FXML
    public void setPlayerGreedy() {
        Player player = new ComputerPlayer("greedy", matrixPane.getGrid().getCell(0, 0), new GreedyStrategy(availableColors));
        game.setPlayer(player);
    }

}
