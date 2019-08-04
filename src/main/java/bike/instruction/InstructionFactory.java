package bike.instruction;

import bike.instruction.command.Instruction;

public interface InstructionFactory {

    boolean validInstruction(String input);
    Instruction fromInput(String input); // could have this interface return an Optional instead

}
