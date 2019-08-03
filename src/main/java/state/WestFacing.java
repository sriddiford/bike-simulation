package state;

import bike.Bike;

public class WestFacing extends FacingDirection {

    private Bike bike;

    public WestFacing(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void forward() {
        if (bike.getxCoordinate() > 0) {
            bike.setxCoordinate(bike.getxCoordinate() - 1);
        }
    }

    @Override
    public void turnLeft() {
        bike.setCurrentDirection(bike.getSouthFacingDirection());
    }

    @Override
    public void turnRight() {
        bike.setCurrentDirection(bike.getNorthFacingDirection());
    }

    @Override
    public String toString() {
        return "WEST";
    }
}
