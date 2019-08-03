package state;

public class UndefinedFacing extends FacingDirection {

    @Override
    public void forward() {
        // empty body
    }

    @Override
    public void turnLeft() {
        // empty body
    }

    @Override
    public void turnRight() {
        // empty body
    }

    @Override
    public String toString() {
        return "Not initialized, not facing any direction!";
    }
}
