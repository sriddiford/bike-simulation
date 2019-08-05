import bike.VirtualBike;
import bike.instruction.VirtualRider;
import bike.direction.CardinalDirection;
import bike.instruction.command.GPSReportInstruction;
import bike.instruction.command.Instruction;
import bike.instruction.command.PlaceInstruction;
import bike.state.NorthFacing;
import bike.state.SouthFacing;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class VirtualBikeOutputTest {

    // holds System.out output
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        // redirects System.out to allow its output to be tested
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        // restore System.out to original output stream after all tests
        System.setOut(originalOut);
    }

    @Test
    void out() {
        System.out.print("Test");
        assertThat(outContent.toString()).isEqualTo("Test");
    }

    @Test
    void gpsReportFormatTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new SouthFacing(virtualBike));
        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), SOUTH\n");
    }

    @Test
    void defaultFacingDirectionTest() {
        VirtualBike bike = new VirtualBike(1, 2);
        assertThat(bike.getFacingDirection().toString()).isEqualTo("NORTH");
    }

    @Test
    void placeTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));
        Instruction placeInstruction = new PlaceInstruction(virtualBike, 6, 5, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        Instruction gpsReport = new GPSReportInstruction(virtualBike);
        rider.setInstruction(gpsReport);
        rider.completeInstruction();
        assertThat(outContent.toString()).isEqualTo("(6,5), EAST\n");
    }

    @Test
    void badPlaceTestExceedLimit() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));
        Instruction placeInstruction = new PlaceInstruction(virtualBike, 8, 8, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), NORTH\n");
    }

    @Test
    void badPlaceTestLessThanZero() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));
        Instruction placeInstruction = new PlaceInstruction(virtualBike, -1, -1, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), NORTH\n");
    }

}
