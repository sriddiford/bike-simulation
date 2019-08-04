package bike.instruction;

import bike.instruction.command.Instruction;

/**
 * Used to create Instruction instances from a given String input
 */
public interface InstructionFactory {

    /**
     * Returns the Instruction instance specified by the supplied input
     *
     * @param input       the string input to create the Instruction from.
     *                    If the input is not a valid instruction, a no operation
     *                    Instruction instance will be returned (NoInstruction)
     * @return            the outcome of performing the forward action
     *                    A NoInstruction instance can be returned for an invalid input
     */
    Instruction fromInput(String input);

}
