import bike.VirtualBike;
import bike.instruction.VirtualRider;
import bike.instruction.command.ForwardInstruction;
import bike.instruction.command.Instruction;
import bike.instruction.command.TurnLeftInstruction;
import bike.instruction.command.TurnRightInstruction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VirtualBikeMovementTest {

    @Test
    void turnRightTest() {
        // turns right 4 time successively initially facing North
        VirtualBike bike = new VirtualBike(1, 7);
        Instruction turnRightInstruction = new TurnRightInstruction(bike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(turnRightInstruction);
        List<String> expectedDirections = Arrays.asList("EAST", "SOUTH", "WEST", "NORTH");
        for (int i = 0; i < 4; i++) {
            rider.completeInstruction();
            assertThat(bike.getFacingDirection().toString()).isEqualTo(expectedDirections.get(i));
        }
    }

    @Test
    void turnsLeftTest() {
        // turns left 4 time successively initially facing North
        VirtualBike bike = new VirtualBike(1, 7);
        Instruction turnLeftInstruction = new TurnLeftInstruction(bike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(turnLeftInstruction);
        List<String> expectedDirections = Arrays.asList("WEST", "SOUTH", "EAST", "NORTH");
        for (int i = 0; i < 4; i++) {
            rider.completeInstruction();
            assertThat(bike.getFacingDirection().toString()).isEqualTo(expectedDirections.get(i));
        }
    }

    @Test
    void southMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(virtualBike.getSouthFacingDirection());

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        assertThat(virtualBike.getxCoordinate()).isEqualTo(1);
        assertThat(virtualBike.getyCoordinate()).isEqualTo(1);
        assertThat(virtualBike.getFacingDirection().toString()).isEqualTo("SOUTH");
    }

    @Test
    void northMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(virtualBike.getNorthFacingDirection());

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        assertThat(virtualBike.getxCoordinate()).isEqualTo(1);
        assertThat(virtualBike.getyCoordinate()).isEqualTo(3);
        assertThat(virtualBike.getFacingDirection().toString()).isEqualTo("NORTH");
    }

    @Test
    void eastMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(virtualBike.getEastFacingDirection());

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        assertThat(virtualBike.getxCoordinate()).isEqualTo(2);
        assertThat(virtualBike.getyCoordinate()).isEqualTo(2);
        assertThat(virtualBike.getFacingDirection().toString()).isEqualTo("EAST");
    }

    @Test
    void westMoveForwardTest() {
        VirtualBike virtualBike = new VirtualBike(1, 2);
        virtualBike.setFacingDirection(virtualBike.getWestFacingDirection());

        Instruction forwardInstruction = new ForwardInstruction(virtualBike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forwardInstruction);
        rider.completeInstruction();

        assertThat(virtualBike.getxCoordinate()).isEqualTo(0);
        assertThat(virtualBike.getyCoordinate()).isEqualTo(2);
        assertThat(virtualBike.getFacingDirection().toString()).isEqualTo("WEST");
    }

    @Test
    void northWestCornerTest() {
        // should stay in nw corner when moving north, turning left, and trying to move forward (west) again
        int yLimit = 7;
        VirtualBike bike = new VirtualBike(0, yLimit);
        bike.setFacingDirection(bike.getNorthFacingDirection());
        Instruction forward = new ForwardInstruction(bike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forward);
        rider.completeInstruction();

        assertThat(bike.getxCoordinate()).isEqualTo(0);
        assertThat(bike.getyCoordinate()).isEqualTo(yLimit);
        assertThat(bike.getFacingDirection().toString()).isEqualTo("NORTH");

        Instruction turnLeft = new TurnLeftInstruction(bike);
        rider.setInstruction(turnLeft);
        rider.completeInstruction();
        rider.setInstruction(forward);
        rider.completeInstruction();

        assertThat(bike.getxCoordinate()).isEqualTo(0);
        assertThat(bike.getyCoordinate()).isEqualTo(yLimit);
        assertThat(bike.getFacingDirection().toString()).isEqualTo("WEST");
    }

    @Test
    void southEastCornerTest() {
        // should stay in se corner when moving south, turning left, and trying to move forward (east) again
        int xLimit = 7;
        VirtualBike bike = new VirtualBike(xLimit, 0);
        bike.setFacingDirection(bike.getSouthFacingDirection());
        Instruction forward = new ForwardInstruction(bike);
        VirtualRider rider = new VirtualRider();
        rider.setInstruction(forward);
        rider.completeInstruction();

        assertThat(bike.getxCoordinate()).isEqualTo(xLimit);
        assertThat(bike.getyCoordinate()).isEqualTo(0);
        assertThat(bike.getFacingDirection().toString()).isEqualTo("SOUTH");

        Instruction turnLeft = new TurnLeftInstruction(bike);
        rider.setInstruction(turnLeft);
        rider.completeInstruction();
        rider.setInstruction(forward);
        rider.completeInstruction();

        assertThat(bike.getxCoordinate()).isEqualTo(xLimit);
        assertThat(bike.getyCoordinate()).isEqualTo(0);
        assertThat(bike.getFacingDirection().toString()).isEqualTo("EAST");
    }

}
