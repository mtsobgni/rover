package fr.sijo.bnp.service.input;

import fr.sijo.bnp.model.Orientation;
import fr.sijo.bnp.model.RoverWithInstructions;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputServiceTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyExtractDataOfFile() throws IOException {
        //Given
        String fileName = "input.txt";

        //WHEN
        FileInputService fileInputService = new FileInputService(fileName);
        List<RoverWithInstructions> result = fileInputService.parseFileAndExtractData();

        //THEN
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getRover().getPosition().getX(), 1);
        assertEquals(result.get(0).getRover().getPosition().getY(), 2);
        assertEquals(result.get(0).getRover().getOrientation(), Orientation.N);
        assertEquals(result.get(0).getInstruction(), "LMLMLMLMM");
        assertEquals(result.get(0).getPlateau().getMaxPosition().getX(), 5);
        assertEquals(result.get(0).getPlateau().getMaxPosition().getY(), 5);

        assertEquals(result.get(1).getRover().getPosition().getX(), 3);
        assertEquals(result.get(1).getRover().getPosition().getY(), 3);
        assertEquals(result.get(1).getRover().getOrientation(), Orientation.E);
        assertEquals(result.get(1).getInstruction(), "MMRMMRMRRM");
        assertEquals(result.get(1).getPlateau().getMaxPosition().getX(), 5);
        assertEquals(result.get(1).getPlateau().getMaxPosition().getY(), 5);
    }

}
