import bike.Simulation;
import bike.VirtualBike;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        VirtualBike bike = new VirtualBike(0,0);
        Simulation simulation = new Simulation(bike);
        simulation.start(args);
    }
}
