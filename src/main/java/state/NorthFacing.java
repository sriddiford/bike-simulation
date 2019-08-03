package state;

import bike.VirtualBike;

public class NorthFacing extends FacingDirection {

    private VirtualBike virtualBike;

    public NorthFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void forward() {
        if (virtualBike.getyCoordinate() < virtualBike.getyLimit()) {
            virtualBike.setyCoordinate(virtualBike.getyCoordinate() + 1);
        }
    }

    @Override
    public void turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getWestFacingDirection());
    }

    @Override
    public void turnRight() {
        virtualBike.setFacingDirection(virtualBike.getEastFacingDirection());
    }

    @Override
    public String toString() {
        return "NORTH";
    }
}
