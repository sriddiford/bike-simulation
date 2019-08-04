package bike.instruction.command;

import bike.VirtualBike;

public final class ForwardInstruction implements Instruction {

    private VirtualBike virtualBike;

    public ForwardInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.forward();
    }
}
