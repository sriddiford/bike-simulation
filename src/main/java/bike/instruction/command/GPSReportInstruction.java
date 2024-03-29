package bike.instruction.command;

import bike.VirtualBike;

public final class GPSReportInstruction implements Instruction {

    private VirtualBike virtualBike;

    public GPSReportInstruction(VirtualBike virtualBike) {
        this.virtualBike = virtualBike;
    }

    @Override
    public boolean execute() {
        return virtualBike.GPSReport();
    }
}
