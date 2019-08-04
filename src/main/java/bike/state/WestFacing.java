package bike.state;

import bike.VirtualBike;

public class WestFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public WestFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean forward() {
        if (virtualBike.getxCoordinate() > 0) {
            virtualBike.setxCoordinate(virtualBike.getxCoordinate() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getSouthFacingDirection());
        return true;
    }

    @Override
    public boolean turnRight() {
        virtualBike.setFacingDirection(virtualBike.getNorthFacingDirection());
        return true;
    }

    @Override
    public String toString() {
        return "WEST";
    }
}
