package bike.state;

/**
 * State that represents the direction that the bike is facing.
 * The implementations of this interface's methods will be specific
 * to the represented cardinal direction.
 */
public interface FacingDirection {

    /**
     * Returns if the forward action was completed successfully
     *
     * @return            the outcome of performing the forward action
     */
    boolean forward();

    /**
     * Returns if the turn left action was completed successfully
     *
     * @return            the outcome of performing the turn left action
     */
    boolean turnLeft();

    /**
     * Returns if the turn right was completed successfully
     *
     * @return            the outcome of performing the turn right action
     */
    boolean turnRight();

}
