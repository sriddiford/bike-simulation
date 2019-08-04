package bike.state;

import bike.VirtualBike;
import bike.state.FacingDirection;

public class EastFacing implements FacingDirection {

    private VirtualBike virtualBike;

    public EastFacing(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void forward() {
        if (virtualBike.getxCoordinate() < virtualBike.getxLimit()) {
            virtualBike.setxCoordinate(virtualBike.getxCoordinate() + 1);
        }
    }

    @Override
    public void turnLeft() {
        virtualBike.setFacingDirection(virtualBike.getNorthFacingDirection());
    }

    @Override
    public void turnRight() {
        virtualBike.setFacingDirection(virtualBike.getSouthFacingDirection());
    }

    @Override
    public String toString() {
        return "EAST";
    }
}
