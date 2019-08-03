import bike.VirtualBike;
import bike.VirtualRider;
import instruction.CardinalDirection;
import instruction.PlaceInstruction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import state.NorthFacing;
import state.SouthFacing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class VirtualBikeSystemOutTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    // https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void out() {
        System.out.print("Test");
        assertThat(outContent.toString()).isEqualTo("Test");
    }

    @Test
    public void gpsReportFormatTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new SouthFacing(virtualBike));
        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), SOUTH");
    }

    @Test
    public void placeTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));
        PlaceInstruction placeInstruction = new PlaceInstruction(virtualBike, 6, 5, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(6,5), EAST");
    }

    @Test
    public void badPlaceTest() {
        
    }
}
