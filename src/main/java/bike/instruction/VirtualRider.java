package bike.instruction;

import bike.instruction.command.Instruction;
import bike.instruction.command.NoInstruction;

public class VirtualRider {

    private Instruction instruction;

    public VirtualRider() {
        this.instruction = new NoInstruction();
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public boolean completeInstruction() {
        return instruction.execute();
    }
}
