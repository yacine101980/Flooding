package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerTest {


    @Test
    void testSetStrategyAndPlay() {
        ComputerPlayer player = new ComputerPlayer(null, new SquareCell());
        player.setPlayStrategy(startCell -> Color.INDIGO);
        assertThat(player.play()).isEqualTo(Color.INDIGO);
    }


    @Test
    void testIsHuman() {
        assertThat(new ComputerPlayer(null, new SquareCell()).isHuman()).isFalse();
    }
}