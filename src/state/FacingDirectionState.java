package state;

import world.WorldGrid;

public abstract class FacingDirectionState {

    WorldGrid worldGrid;

    abstract void forward();

    abstract void turnLeft();

    abstract void turnRight();

    void printGPSReport() {
        // implement here, makes sense semantically in WorldGrid, but easier to see all steps here
    }

}
