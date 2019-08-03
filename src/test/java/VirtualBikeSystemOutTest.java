import bike.VirtualBike;
import bike.VirtualRider;
import instruction.ForwardInstruction;
import instruction.GPSReportInstruction;
import instruction.Instruction;
import instruction.PlaceInstruction;
import org.junit.jupiter.api.*;
import state.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class VirtualBikeSystemOutTest {

    // holds System.out output
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // redirects System.out to allow its output to be tested
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        // restore System.out to original output stream
        System.setOut(originalOut);
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
        Instruction placeInstruction = new PlaceInstruction(virtualBike, 6, 5, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        Instruction gpsReport = new GPSReportInstruction(virtualBike);
        rider.setInstruction(gpsReport);
        rider.completeInstruction();
        assertThat(outContent.toString()).isEqualTo("(6,5), EAST");
    }

    @Test
    public void badPlaceTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));
        Instruction placeInstruction = new PlaceInstruction(virtualBike, 8, 8, CardinalDirection.EAST);

        VirtualRider rider = new VirtualRider();
        rider.setInstruction(placeInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), NORTH");
    }

    @Test
    public void southMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new SouthFacing(virtualBike));

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,1), SOUTH");
    }

    @Test
    public void northMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new NorthFacing(virtualBike));

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,3), NORTH");
    }

    @Test
    public void eastMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new EastFacing(virtualBike));

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(2,2), EAST");
    }

    @Test
    public void westMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(new WestFacing(virtualBike));

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        virtualBike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(0,2), WEST");
    }
}
