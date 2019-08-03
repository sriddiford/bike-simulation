package instruction;

import bike.VirtualBike;

public class TurnRightInstruction implements Instruction {

    VirtualBike virtualBike;

    public TurnRightInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void execute() {
        virtualBike.turnRight();
    }
}
