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

class FileReadingTest {

    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    private static final String TEST_RESOURCES_FOLDER = "src/test/resources/";

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
    void example1Test() throws FileNotFoundException {
        String filename = "Example1.txt";
        File file = new File(TEST_RESOURCES_FOLDER + filename);
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
    void example2Test() throws FileNotFoundException {
        String filename = "Example2.txt";
        File file = new File(TEST_RESOURCES_FOLDER + filename);
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
    void example3Test() throws FileNotFoundException {
        String filename = "Example3.txt";
        File file = new File(TEST_RESOURCES_FOLDER + filename);
        Scanner scanner = new Scanner(file);
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
        assertThat(outContent.toString()).isEqualTo("(3,3), NORTH\n");
    }

    @Test
    void fileNotFoundTest() throws FileNotFoundException {
        String[] args = {"I don't exist"};
        VirtualBike bike = new VirtualBike(1, 2);
        Simulation simulation = new Simulation(bike);
        simulation.start(args);
        assertThat(outContent.toString())
                .isEqualTo("File not found: Could not find file specified, please check the file name and try again.\n");

    }
}
