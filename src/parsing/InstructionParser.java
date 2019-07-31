package parsing;

import instruction.Instruction;

import java.util.List;

public interface InstructionParser {

    // instructions can come from stdin or a file

    List<Instruction> parseInstructions();

    List<Instruction> parseInstructions();

    // thinking how to separate these
}
