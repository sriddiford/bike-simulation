package bike.state;

import bike.VirtualBike;

public class EastFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public EastFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean forward() {
        if (virtualBike.getxCoordinate() < virtualBike.getxLimit()) {
            virtualBike.setxCoordinate(virtualBike.getxCoordinate() + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getNorthFacingDirection());
        return true;
    }

    @Override
    public boolean turnRight() {
        virtualBike.setFacingDirection(virtualBike.getSouthFacingDirection());
        return true;
    }

    @Override
    public String toString() {
        return "EAST";
    }
}
