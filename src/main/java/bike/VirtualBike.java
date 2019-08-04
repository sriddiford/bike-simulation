package bike;

import bike.direction.CardinalDirection;
import bike.state.*;

public final class VirtualBike {

    private int xLimit = 7;
    private int yLimit = 7;

    private int xCoordinate;
    private int yCoordinate;
    private FacingDirection facingDirection;

    private FacingDirection northFacingDirection = new NorthFacing(this);
    private FacingDirection southFacingDirection = new SouthFacing(this);
    private FacingDirection eastFacingDirection = new EastFacing(this);
    private FacingDirection westFacingDirection = new WestFacing(this);

    public VirtualBike(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.facingDirection = new NorthFacing(this);
    }

    public VirtualBike(int xCoordinate, int yCoordinate, FacingDirection facingDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.facingDirection = facingDirection;
    }

    public boolean turnRight() {
        return facingDirection.turnRight();
    }

    public boolean turnLeft() {
        return facingDirection.turnLeft();
    }

    public boolean forward() {
        return facingDirection.forward();
    }

    public boolean GPSReport() {
        System.out.printf("(%d,%d), %s\n", this.xCoordinate, this.yCoordinate, this.facingDirection.toString());
        return true;
    }

    public boolean place(int newXCoordinate, int newYCoordinate, CardinalDirection newDirection) {
        if (newXCoordinate > xLimit || newYCoordinate > yLimit || newXCoordinate < 0 || newYCoordinate < 0) {
            return false;
        }
        this.xCoordinate = newXCoordinate;
        this.yCoordinate = newYCoordinate;
        switch (newDirection) {
            case NORTH:
                this.facingDirection = this.getNorthFacingDirection();
                return true;
            case EAST:
                this.facingDirection = this.getEastFacingDirection();
                return true;
            case SOUTH:
                this.facingDirection = this.getSouthFacingDirection();
                return true;
            case WEST:
                this.facingDirection = this.getWestFacingDirection();
                return true;
        }
        return false;
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

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }
}
