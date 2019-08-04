import bike.Simulation;
import bike.VirtualBike;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class FileReadingTest {

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
        // restore System.out to original output stream after all tests
        System.setOut(originalOut);
    }

    @Test
    public void example1Test() throws FileNotFoundException {
        String testResourcesFolder = "src/test/resources/";
        String filename = "Example1.txt";
        File file = new File(testResourcesFolder + filename);
        Scanner scanner = new Scanner(file);
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
        assertThat(outContent.toString()).isEqualTo("(0,6), NORTH\n");

    }

    @Test
    public void example2Test() throws FileNotFoundException {
        String testResourcesFolder = "src/test/resources/";
        String filename = "Example2.txt";
        File file = new File(testResourcesFolder + filename);
        Scanner scanner = new Scanner(file);
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
        assertThat(outContent.toString()).isEqualTo("(0,0), WEST\n");

    }

    @Test
    public void example3Test() throws FileNotFoundException {
        String testResourcesFolder = "src/test/resources/";
        String filename = "Example3.txt";
        File file = new File(testResourcesFolder + filename);
        Scanner scanner = new Scanner(file);
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
        assertThat(outContent.toString()).isEqualTo("(3,3), NORTH\n");

    }
}
