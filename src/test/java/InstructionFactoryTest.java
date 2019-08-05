import bike.VirtualBike;
import bike.direction.CardinalDirection;
import bike.instruction.InstructionFactory;
import bike.instruction.TextFileInstructionFactory;
import bike.instruction.command.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionFactoryTest {

    @Test
    void shouldReturnForwardInstruction() {
        String input = "FORWARD";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(ForwardInstruction.class);
    }

    @Test
    void shouldReturnTurnLeftInstruction() {
        String input = "TURN_LEFT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(TurnLeftInstruction.class);
    }

    @Test
    void shouldReturnTurnRightInstruction() {
        String input = "TURN_RIGHT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(TurnRightInstruction.class);
    }

    @Test
    void shouldReturnGPSReportInstruction() {
        String input = "GPS_REPORT";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isExactlyInstanceOf(GPSReportInstruction.class);
    }

    @Test
    void shouldReturnPlaceInstruction() {
        String input = "PLACE 0,0,NORTH";
        VirtualBike bike = new VirtualBike(1, 2);
        InstructionFactory instructionFactory = new TextFileInstructionFactory(bike);
        Instruction instruction = instructionFactory.fromInput(input);
        assertThat(instruction).isEqualToComparingFieldByField(new PlaceInstruction(bike, 0, 0, CardinalDirection.NORTH));
    }

    @Test
    void noDirectionPlaceTest() {
        String input = "PLACE 1,2,";
        VirtualBike bike = new VirtualBike(1,2);
        InstructionFactory factory = new TextFileInstructionFactory(bike);
        Instruction instruction = factory.fromInput(input);
        assertThat(instruction).isInstanceOf(NoInstruction.class);
    }

    @Test
    void emptyStringInstructionTest() {
        String input = "";
        VirtualBike bike = new VirtualBike(1,2);
        InstructionFactory factory = new TextFileInstructionFactory(bike);
        Instruction instruction = factory.fromInput(input);
        assertThat(instruction).isInstanceOf(NoInstruction.class);
    }

    @Test
    void invalidInstructionTest() {
        String input = "Go bike, go!";
        VirtualBike bike = new VirtualBike(1,2);
        InstructionFactory factory = new TextFileInstructionFactory(bike);
        Instruction instruction = factory.fromInput(input);
        assertThat(instruction).isInstanceOf(NoInstruction.class);
    }

}
