import bike.Simulation;
import bike.VirtualBike;
import bike.instruction.InstructionFactory;
import bike.instruction.TextFileInstructionFactory;
import bike.instruction.VirtualRider;
import bike.instruction.command.Instruction;
import bike.instruction.command.PlaceInstruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner;
        if (args.length > 0) {
            File file = new File(args[0]);
            if (file.exists()) {
                scanner = new Scanner(file);
            } else {
                System.out.println("Could not find file specified, " +
                        "please check the file name and try again " +
                        "or continue by entering bike commands:");
                scanner = new Scanner(System.in);
            }
        } else {
            scanner = new Scanner(System.in);
        }
        System.out.println("Please enter bike commands:");
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
    }
}
