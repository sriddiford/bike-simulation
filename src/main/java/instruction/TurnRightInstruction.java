package instruction;

import bike.Bike;

public class TurnRightInstruction implements Instruction {

    Bike bike;

    @Override
    public void execute() {
        bike.turnRight();
    }
}
