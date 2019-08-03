package instruction;

import bike.VirtualBike;

public class ForwardInstruction implements Instruction {

    VirtualBike virtualBike;

    @Override
    public void execute() {
        virtualBike.forward();
    }
}
