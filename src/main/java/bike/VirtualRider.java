package bike;

import instruction.Instruction;

public class VirtualRider {

    Instruction instruction;

    public VirtualRider() {
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public void completeInstruction() {
        instruction.execute();
    }
}
