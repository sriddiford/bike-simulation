package instruction;

import bike.Bike;

public class TurnLeftInstruction implements Instruction {

    Bike bike;

    @Override
    public void execute() {
        bike.turnLeft();
    }
}
