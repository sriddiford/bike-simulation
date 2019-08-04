package bike.state;

import bike.VirtualBike;
import bike.state.FacingDirection;

public class WestFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public WestFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void forward() {
        if (virtualBike.getxCoordinate() > 0) {
            virtualBike.setxCoordinate(virtualBike.getxCoordinate() - 1);
        }
    }

    @Override
    public void turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getSouthFacingDirection());
    }

    @Override
    public void turnRight() {
        virtualBike.setFacingDirection(virtualBike.getNorthFacingDirection());
    }

    @Override
    public String toString() {
        return "WEST";
    }
}
