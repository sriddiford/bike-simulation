package bike.state;

import bike.VirtualBike;
import bike.state.FacingDirection;

public class SouthFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public SouthFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void forward() {
        if (virtualBike.getyCoordinate() > 0) {
            virtualBike.setyCoordinate(virtualBike.getyCoordinate() - 1);
        }
    }

    @Override
    public void turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getEastFacingDirection());
    }

    @Override
    public void turnRight() {
        virtualBike.setFacingDirection(virtualBike.getWestFacingDirection());
    }

    @Override
    public String toString() {
        return "SOUTH";
    }
}
