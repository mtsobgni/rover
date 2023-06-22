package fr.sijo.bnp.service;

import fr.sijo.bnp.model.*;
import fr.sijo.bnp.service.input.FileInputService;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyExecuteCommand() {
        //Given
        Plateau plateau = new Plateau(new Position(5, 5));
        MarsRoverService marsRoverService = new MarsRoverService();
        Rover rover = new Rover(new Position(1, 2), Orientation.N);
        String instruction = "LMLMLMLMM";

        //WHEN
       marsRoverService.executeCommand(plateau, rover, instruction);

        //THEN
        assertEquals(rover.getOrientation(), Orientation.N);
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 3);
    }
}
