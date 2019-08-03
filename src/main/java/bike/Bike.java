package bike;

import state.*;

public class Bike {

    private int xLimit = 7; // TODO use a bike builder and set these programatically
    private int yLimit = 7;

    private int xCoordinate;
    private int yCoordinate;

    private FacingDirection northFacingDirection;
    private FacingDirection southFacingDirection;
    private FacingDirection eastFacingDirection;
    private FacingDirection westFacingDirection;

    private FacingDirection currentDirection;

    public Bike(int xCoordinate, int yCoordinate) {
        this(xCoordinate, yCoordinate, new UndefinedFacing());
    }

    public Bike(int xCoordinate, int yCoordinate, FacingDirection currentDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.currentDirection = currentDirection;

        northFacingDirection = new NorthFacing(this);
        southFacingDirection = new SouthFacing(this);
        eastFacingDirection = new EastFacing(this);
        westFacingDirection = new WestFacing(this);
    }

    public void turnRight() {
        currentDirection.turnRight();
    }

    public void turnLeft() {
        currentDirection.turnLeft();
    }

    public void forward() {
        currentDirection.forward();
    }

    public void GPSReport() {
        System.out.printf("(%d,%d), %s", this.xCoordinate, this.yCoordinate, this.currentDirection);
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

    public void setCurrentDirection(FacingDirection currentDirection) {
        this.currentDirection = currentDirection;
    }


}
