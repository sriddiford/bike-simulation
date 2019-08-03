package instruction;

import bike.VirtualBike;

public class GPSReportInstruction implements Instruction {

    VirtualBike virtualBike;

    public GPSReportInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public void execute() {
        virtualBike.GPSReport();
    }
}
