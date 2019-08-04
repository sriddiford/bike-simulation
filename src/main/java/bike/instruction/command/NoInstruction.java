package bike.instruction.command;

public class NoInstruction implements Instruction {

    @Override
    public boolean execute() {
        return false;
    }
}
