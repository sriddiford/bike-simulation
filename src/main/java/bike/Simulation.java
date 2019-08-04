package bike;

import bike.instruction.InstructionFactory;
import bike.instruction.TextFileInstructionFactory;
import bike.instruction.VirtualRider;
import bike.instruction.command.Instruction;
import bike.instruction.command.PlaceInstruction;

public class Simulation {

    private InstructionFactory factory;
    private VirtualRider rider;

    private boolean firstValidPlaceInstructionSeen = false;

    public Simulation(VirtualBike bike) {
        this.factory = new TextFileInstructionFactory(bike);
        this.rider = new VirtualRider();
    }

    public void simulateInstruction(String input) {
        Instruction instruction1 = factory.fromInput(input);
        if (instruction1 instanceof PlaceInstruction) {
            rider.setInstruction(instruction1);
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
