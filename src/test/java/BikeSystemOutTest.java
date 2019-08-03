import bike.Bike;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import state.EastFacing;
import state.SouthFacing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BikeSystemOutTest {

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
        Bike bike = new Bike(1, 2);
        bike.setCurrentDirection(new SouthFacing(bike));
        bike.GPSReport();
        assertThat(outContent.toString()).isEqualTo("(1,2), SOUTH");
    }
}
