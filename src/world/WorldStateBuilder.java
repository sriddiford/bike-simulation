package world;

import direction.Direction;

public class WorldStateBuilder {

    private int xDimensionLimit;
    private int yDimensionLimit;
    private int bikeXLocation;
    private int bikeYLocation;
    private Direction bikeFacingDirection;

    public WorldStateBuilder setxDimensionLimit(int xDimensionLimit) {
        this.xDimensionLimit = xDimensionLimit;
        return this;
    }

    public WorldStateBuilder setyDimensionLimit(int yDimensionLimit) {
        this.yDimensionLimit = yDimensionLimit;
        return this;
    }

    public WorldStateBuilder setBikeXLocation(int bikeXLocation) {
        this.bikeXLocation = bikeXLocation;
        return this;
    }

    public WorldStateBuilder setBikeYLocation(int bikeYLocation) {
        this.bikeYLocation = bikeYLocation;
        return this;
    }

    public WorldStateBuilder setBikeFacingDirection(Direction bikeFacingDirection) {
        this.bikeFacingDirection = bikeFacingDirection;
        return this;
    }

    public WorldGrid createWorldState() {
        return new WorldGrid(xDimensionLimit, yDimensionLimit, bikeXLocation, bikeYLocation, bikeFacingDirection);
    }
}