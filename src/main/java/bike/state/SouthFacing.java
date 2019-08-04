package bike.state;

import bike.VirtualBike;
import bike.state.FacingDirection;

public class SouthFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public SouthFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean forward() {
        if (virtualBike.getyCoordinate() > 0) {
            virtualBike.setyCoordinate(virtualBike.getyCoordinate() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getEastFacingDirection());
        return true;
    }

    @Override
    public boolean turnRight() {
        virtualBike.setFacingDirection(virtualBike.getWestFacingDirection());
        return true;
    }

    @Override
    public String toString() {
        return "SOUTH";
    }
}
