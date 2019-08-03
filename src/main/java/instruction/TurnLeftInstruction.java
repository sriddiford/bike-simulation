package instruction;

import bike.VirtualBike;

public class TurnLeftInstruction implements Instruction {

    VirtualBike virtualBike;

    public TurnLeftInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void execute() {
        virtualBike.turnLeft();
    }
}
