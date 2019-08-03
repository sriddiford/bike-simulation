package instruction;

import bike.VirtualBike;

public class TurnRightInstruction implements Instruction {

    VirtualBike virtualBike;

    @Override
    public void execute() {
        virtualBike.turnRight();
    }
}
