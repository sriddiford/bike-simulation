package state;

import bike.Bike;

public class NorthFacing extends FacingDirection {

    private Bike bike;

    public NorthFacing(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void forward() {
        if (bike.getyCoordinate() < bike.getyLimit()) {
            bike.setyCoordinate(bike.getyCoordinate() + 1);
        }
    }

    @Override
    public void turnLeft() {
        bike.setCurrentDirection(bike.getWestFacingDirection());
    }

    @Override
    public void turnRight() {
        bike.setCurrentDirection(bike.getEastFacingDirection());
    }

    @Override
    public String toString() {
        return "NORTH";
    }
}
