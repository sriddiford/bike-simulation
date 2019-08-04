package bike.instruction.command;

/**
 * Used to represent an issued command to the simulated bike.
 */
public interface Instruction {

    /**
     * Indicates if the instruction was executed successfully.
     * This is determined by the constraints of the simulation.
     *
     * E.g. this would return false for the following:
     * - any movement where the bike attempts to move outside the grid
     * - a place command that would place the bike outside the grid
     *
     * @return            the outcome of attempting to execute the command
     */
    boolean execute();

}
