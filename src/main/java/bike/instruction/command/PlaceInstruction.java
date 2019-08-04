package bike.instruction.command;

import bike.VirtualBike;
import bike.direction.CardinalDirection;

public class PlaceInstruction implements Instruction {

    private VirtualBike virtualBike;

    private int newXCoordinate;
    private int newYCoordinate;
    private CardinalDirection newDirection;;

    public PlaceInstruction(VirtualBike virtualBike, int newXCoordinate, int newYCoordinate, CardinalDirection newDirection) {
        this.virtualBike = virtualBike;
        this.newXCoordinate = newXCoordinate;
        this.newYCoordinate = newYCoordinate;
        this.newDirection = newDirection;
    }

    @Override
    public boolean execute() {
        return virtualBike.place(newXCoordinate, newYCoordinate, newDirection);
    }
}
