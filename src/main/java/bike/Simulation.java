package bike;

import bike.instruction.InstructionFactory;
import bike.instruction.TextFileInstructionFactory;
import bike.instruction.VirtualRider;
import bike.instruction.command.Instruction;
import bike.instruction.command.PlaceInstruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {

    private InstructionFactory factory;
    private VirtualRider rider;

    private boolean firstValidPlaceInstructionSeen = false;

    public Simulation(VirtualBike bike) {
        this.factory = new TextFileInstructionFactory(bike);
        this.rider = new VirtualRider();
    }

    public void start(String[] args) throws FileNotFoundException {
        Scanner scanner;
        if (args.length > 0) {
            File file = new File(args[0]);
            if (file.exists()) {
                scanner = new Scanner(file);
            } else {
                System.out.print("File not found: Could not find file specified, please check the file name and try again.\n");
                return;
            }
        } else {
            scanner = new Scanner(System.in);
        }
        System.out.print("Please enter bike commands:\n");
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            simulation.simulateInstruction(input);
        }
    }

    public void simulateInstruction(String input) {
        Instruction firstInstruction = factory.fromInput(input);
        if (firstInstruction instanceof PlaceInstruction) {
            rider.setInstruction(firstInstruction);
            if (rider.completeInstruction()) {
                firstValidPlaceInstructionSeen = true;
            }
        }
        if (firstValidPlaceInstructionSeen) {
            Instruction instruction = factory.fromInput(input);
            rider.setInstruction(instruction);
            rider.completeInstruction();
        }
    }

}
