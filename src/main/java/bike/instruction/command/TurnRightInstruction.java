package bike.instruction.command;

import bike.VirtualBike;

public class TurnRightInstruction implements Instruction {

    private VirtualBike virtualBike;

    public TurnRightInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.turnRight();
    }
}
