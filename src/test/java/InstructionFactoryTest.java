import bike.VirtualBike;
import bike.direction.CardinalDirection;
import bike.instruction.*;
import bike.instruction.command.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructionFactoryTest {

    @Test
    public void shouldReturnForwardInstruction() {
        String input = "FORWARD";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(ForwardInstruction.class);
    }

    @Test
    public void shouldReturnTurnLeftInstruction() {
        String input = "TURN_LEFT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(TurnLeftInstruction.class);
    }

    @Test
    public void shouldReturnTurnRightInstruction() {
        String input = "TURN_RIGHT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(TurnRightInstruction.class);
    }

    @Test
    public void shouldReturnGPSReportInstruction() {
        String input = "GPS_REPORT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(GPSReportInstruction.class);
    }

    @Test
    public void shouldReturnPlaceInstruction() {
        String input = "PLACE 0,0,NORTH";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isEqualToComparingFieldByField(new PlaceInstruction(bike, 0, 0, CardinalDirection.NORTH));
    }
}
