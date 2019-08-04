package bike.instruction.command;

import bike.VirtualBike;

public class ForwardInstruction implements Instruction {

    VirtualBike virtualBike;

    public ForwardInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.forward();
    }
}
