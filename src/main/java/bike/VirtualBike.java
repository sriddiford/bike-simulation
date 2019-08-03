package bike;

import state.*;

public class VirtualBike {

    private int xLimit = 7; // TODO use a bike builder and set these programmatically
    private int yLimit = 7;

    private int xCoordinate;
    private int yCoordinate;

    private FacingDirection northFacingDirection;
    private FacingDirection southFacingDirection;
    private FacingDirection eastFacingDirection;
    private FacingDirection westFacingDirection;

    private FacingDirection facingDirection;

    public VirtualBike(int xCoordinate, int yCoordinate) {
        this(xCoordinate, yCoordinate, new UndefinedFacing());
    }

    public VirtualBike(int xCoordinate, int yCoordinate, FacingDirection facingDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.facingDirection = facingDirection;

        northFacingDirection = new NorthFacing(this);
        southFacingDirection = new SouthFacing(this);
        eastFacingDirection = new EastFacing(this);
        westFacingDirection = new WestFacing(this);
    }

    public void turnRight() {
        facingDirection.turnRight();
    }

    public void turnLeft() {
        facingDirection.turnLeft();
    }

    public void forward() {
        facingDirection.forward();
    }

    public void GPSReport() {
        System.out.printf("(%d,%d), %s", this.xCoordinate, this.yCoordinate, this.facingDirection);
    }

    public void place(int newXCoordinate, int newYCoordinate, CardinalDirection newDirection) {
        if (newXCoordinate > xLimit || newYCoordinate > yLimit) {
            return;
        }
        this.xCoordinate = newXCoordinate;
        this.yCoordinate = newYCoordinate;
        switch (newDirection) {
            case NORTH:
                this.facingDirection = this.getNorthFacingDirection();
                break;
            case EAST:
                this.facingDirection = this.getEastFacingDirection();
                break;
            case SOUTH:
                this.facingDirection = this.getSouthFacingDirection();
                break;
            case WEST:
                this.facingDirection = this.getWestFacingDirection();
                break;
        }
    }

    public int getxLimit() {
        return xLimit;
    }

    public int getyLimit() {
        return yLimit;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public FacingDirection getNorthFacingDirection() {
        return northFacingDirection;
    }

    public FacingDirection getSouthFacingDirection() {
        return southFacingDirection;
    }

    public FacingDirection getEastFacingDirection() {
        return eastFacingDirection;
    }

    public FacingDirection getWestFacingDirection() {
        return westFacingDirection;
    }

    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }


}
