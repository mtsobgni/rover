package fr.sijo.bnp;

import fr.sijo.bnp.model.Orientation;
import fr.sijo.bnp.model.Position;
import fr.sijo.bnp.model.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @org.junit.jupiter.api.Test
    public void shoulCorretlyExecuteCommandOfRover() {
        //Given
        Position maxPosition = new Position(5, 5);
        Position position = new Position(1, 2);
        Rover rover = new Rover(position, Orientation.N);
        String instructions = "LMLMLMLMM";

        //WHEN
        rover.executeCommand(instructions, maxPosition);

        //THEN
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 3);
        assertEquals(rover.getOrientation(), Orientation.N);
    }

}
