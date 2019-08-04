package bike.instruction;

import bike.VirtualBike;
import bike.direction.CardinalDirection;
import bike.instruction.command.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileInstructionFactory implements InstructionFactory {

    private static final Pattern PLACE_INSTRUCTION =
            Pattern.compile("PLACE (?<xCoord>(\\d*?)),(?<yCoord>(\\d*?)),(?<direction>(NORTH|EAST|SOUTH|WEST))");

    VirtualBike bike;

    public TextFileInstructionFactory(VirtualBike bike) {
        this.bike = bike;
    }

    @Override
    public boolean validInstruction(String input) {
        return false;
    }

    @Override
    public Instruction fromInput(String input) {
        Matcher matcher = PLACE_INSTRUCTION.matcher(input);
        if (matcher.find()) {
            int xCoord = Integer.parseInt(matcher.group("xCoord"));
            int yCoord = Integer.parseInt(matcher.group("yCoord"));
            CardinalDirection direction;
            switch (matcher.group("direction")) {
                case "NORTH":
                    direction = CardinalDirection.NORTH;
                    break;
                case "EAST":
                    direction = CardinalDirection.EAST;
                    break;
                case "SOUTH":
                    direction = CardinalDirection.SOUTH;
                    break;
                case "WEST":
                    direction = CardinalDirection.WEST;
                    break;
                default:
                    // should never be reached
                    direction = CardinalDirection.UNDEFINED;
                    break;
            }
            return new PlaceInstruction(bike, xCoord, yCoord , direction);
        }
        // don't do validation here, its sole job is to parse out the values
        switch (input) {
            case "FORWARD":
                return new ForwardInstruction(bike);
            case "TURN_LEFT":
                return new TurnLeftInstruction(bike);
            case "TURN_RIGHT":
                return new TurnRightInstruction(bike);
            case "GPS_REPORT":
                return new GPSReportInstruction(bike);
            default:
                return new NoInstruction();
        }
    }
}
