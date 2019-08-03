package instruction;

import bike.VirtualBike;

public class TurnLeftInstruction implements Instruction {

    VirtualBike virtualBike;

    @Override
    public void execute() {
        virtualBike.turnLeft();
    }
}
