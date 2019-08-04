package bike.state;

import bike.VirtualBike;

public final class NorthFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public NorthFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean forward() {
        if (virtualBike.getyCoordinate() < virtualBike.getyLimit()) {
            virtualBike.setyCoordinate(virtualBike.getyCoordinate() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getWestFacingDirection());
        return true;
    }

    @Override
    public boolean turnRight() {
        virtualBike.setFacingDirection(virtualBike.getEastFacingDirection());
        return true;
    }

    @Override
    public String toString() {
        return "NORTH";
    }
}
