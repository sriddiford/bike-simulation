package state;

import bike.Bike;

public class SouthFacing extends FacingDirection {

    private Bike bike;

    public SouthFacing(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void forward() {
        if (bike.getyCoordinate() > 0) {
            bike.setyCoordinate(bike.getyCoordinate() - 1);
        }
    }

    @Override
    public void turnLeft() {
        bike.setCurrentDirection(bike.getEastFacingDirection());
    }

    @Override
    public void turnRight() {
        bike.setCurrentDirection(bike.getWestFacingDirection());
    }

    @Override
    public String toString() {
        return "SOUTH";
    }
}
