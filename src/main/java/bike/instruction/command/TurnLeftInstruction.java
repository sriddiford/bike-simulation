package bike.instruction.command;

import bike.VirtualBike;

public final class TurnLeftInstruction implements Instruction {

    private VirtualBike virtualBike;

    public TurnLeftInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.turnLeft();
    }
}
