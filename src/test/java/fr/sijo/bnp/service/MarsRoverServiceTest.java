package fr.sijo.bnp.service;

import fr.sijo.bnp.model.Orientation;
import fr.sijo.bnp.model.Position;
import fr.sijo.bnp.model.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyExecuteCommand() {
        //Given
        MarsRoverService marsRoverService = new MarsRoverService();
        Rover rover = new Rover(new Position(1, 2), Orientation.N);
        String instruction = "LMLMLMLMM";

        //WHEN
       marsRoverService.executeCommand(rover, instruction);

        //THEN
        assertEquals(rover.getOrientation(), Orientation.N);
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 3);
    }
}
