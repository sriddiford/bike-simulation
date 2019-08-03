package instruction;

import bike.VirtualBike;
import state.CardinalDirection;

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
    public void execute() {
        virtualBike.place(newXCoordinate, newYCoordinate, newDirection);
    }
}
