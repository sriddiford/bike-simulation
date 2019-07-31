package world;

import direction.Direction;
import instruction.Instruction;

public class WorldGrid {

    private final int xDimensionLimit;
    private final int yDimensionLimit;

    private int bikeXLocation;
    private int bikeYLocation;
    private Direction bikeFacingDirection;

    public WorldGrid(int xDimensionLimit, int yDimensionLimit, int bikeXLocation, int bikeYLocation, Direction bikeFacingDirection) {
        this.xDimensionLimit = xDimensionLimit;
        this.yDimensionLimit = yDimensionLimit;
        this.bikeXLocation = bikeXLocation;
        this.bikeYLocation = bikeYLocation;
        this.bikeFacingDirection = bikeFacingDirection;
    }

    public int getxDimensionLimit() {
        return xDimensionLimit;
    }

    public int getyDimensionLimit() {
        return yDimensionLimit;
    }

    public int getBikeXLocation() {
        return bikeXLocation;
    }

    public int getBikeYLocation() {
        return bikeYLocation;
    }

    public Direction getBikeFacingDirection() {
        return bikeFacingDirection;
    }

    public WorldGrid apply(Instruction instruction) {
        instruction.execute();
    }

    // give it some dimensions, these are instantiated when creating the world
}
