package instruction;

import bike.Bike;

public class ForwardInstruction implements Instruction {

    Bike bike;

    @Override
    public void execute() {
        bike.forward();
    }
}
