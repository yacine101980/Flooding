package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FlooderTest {

    private static ArrayGrid gridThreeThree;

    static {
        try {
            gridThreeThree = new ArrayGrid(3,3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeAll
    private static void initializeColorsGrid(){
        gridThreeThree.getCell(0,0).setColor(Color.RED);
        gridThreeThree.getCell(0,1).setColor(Color.BLACK);
        gridThreeThree.getCell(0,2).setColor(Color.RED);
        gridThreeThree.getCell(1,0).setColor(Color.RED);
        gridThreeThree.getCell(1,1).setColor(Color.RED);
        gridThreeThree.getCell(1,2).setColor(Color.BLACK);
        gridThreeThree.getCell(2,0).setColor(Color.BLACK);
        gridThreeThree.getCell(2,1).setColor(Color.BLACK);
        gridThreeThree.getCell(2,2).setColor(Color.RED);
    }

    @Test
    public void testFlood(){
        ColoredCellIterator redCellIterator = new ColoredCellIterator(gridThreeThree.getCell(0,0));

        Flooder.flood(gridThreeThree.getCell(0,0), Color.BLUE);
        assertThat(gridThreeThree.getCell(0,0).getColor()).isEqualTo( Color.BLUE);
        assertThat(gridThreeThree.getCell(1,0).getColor()).isEqualTo( Color.BLUE);
        assertThat(gridThreeThree.getCell(1,1).getColor()).isEqualTo( Color.BLUE);

        Flooder.flood(gridThreeThree.getCell(0,1), Color.BLUE);
        assertThat(gridThreeThree.getCell(0,1).getColor()).isEqualTo( Color.BLUE);

        Flooder.flood(gridThreeThree.getCell(1,2), Color.BLUE);
        assertThat(gridThreeThree.getCell(1,2).getColor()).isEqualTo( Color.BLUE);

        Flooder.flood(gridThreeThree.getCell(0,2), Color.BLUE);
        assertThat(gridThreeThree.getCell(0,2).getColor()).isEqualTo( Color.BLUE);

        Flooder.flood(gridThreeThree.getCell(2,0), Color.BLUE);
        assertThat(gridThreeThree.getCell(2,0).getColor()).isEqualTo( Color.BLUE);
        assertThat(gridThreeThree.getCell(2,1).getColor()).isEqualTo( Color.BLUE);

        Flooder.flood(gridThreeThree.getCell(2,2), Color.BLUE);
        assertThat(gridThreeThree.getCell(2,2).getColor()).isEqualTo( Color.BLUE);
    }

    @Test
    public void testColoredArea(){
        ColoredCellIterator redCellIterator = new ColoredCellIterator(gridThreeThree.getCell(0,0));

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(0,0))).isEqualTo(9);

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(0,1))).isEqualTo(9);

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(1,2))).isEqualTo(9);

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(0,2))).isEqualTo(9);

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(2,0))).isEqualTo(9);

        assertThat(Flooder.coloredArea(gridThreeThree.getCell(2,2))).isEqualTo(9);
    }
}