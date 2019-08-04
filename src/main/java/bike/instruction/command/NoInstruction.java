package bike.instruction.command;

public final class NoInstruction implements Instruction {

    @Override
    public boolean execute() {
        return false;
    }
}
