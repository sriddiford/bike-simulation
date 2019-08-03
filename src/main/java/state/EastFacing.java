package state;

import bike.Bike;

public class EastFacing extends FacingDirection {

    private Bike bike;

    public EastFacing(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void forward() {
        if (bike.getxCoordinate() < bike.getxLimit()) {
            bike.setxCoordinate(bike.getxCoordinate() + 1);
        }
    }

    @Override
    public void turnLeft() {
        bike.setCurrentDirection(bike.getNorthFacingDirection());
    }

    @Override
    public void turnRight() {
        bike.setCurrentDirection(bike.getSouthFacingDirection());
    }

    @Override
    public String toString() {
        return "EAST";
    }
}
