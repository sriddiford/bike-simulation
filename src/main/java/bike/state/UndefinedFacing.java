package bike.state;

import bike.state.FacingDirection;

public class UndefinedFacing implements FacingDirection {

    @Override
    public boolean forward() {
        return false;
    }

    @Override
    public boolean turnLeft() {
        return false;
    }

    @Override
    public boolean turnRight() {
        return false;
    }

    @Override
    public String toString() {
        return "Not initialized, not facing any direction!";
    }
}
