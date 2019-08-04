package bike.instruction.command;

import bike.VirtualBike;

public class TurnLeftInstruction implements Instruction {

    VirtualBike virtualBike;

    public TurnLeftInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.turnLeft();
    }
}