package fr.sijo.bnp.service.input;

import fr.sijo.bnp.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputService {

    private String fileName;

    public FileInputService(String fileName) {
        this.fileName = fileName;
    }

    public List<RoverWithInstructions> parseFileAndExtractData() throws IOException {

        List<RoverWithInstructions> roverWithInstructions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line1 = br.readLine();
            if (line1.isEmpty() || line1 == null) {
                throw new IllegalArgumentException("File could not be empty.");
            }
            Position position = extractMaxPosition(line1);
            Plateau plateau = new Plateau();
            plateau.setMaxPosition(position);

            String line;

            while ((line = br.readLine()) != null) {
                Rover rover = createRover(line);
                String newLine = br.readLine();
                String instruction = createInstruction(newLine);

                RoverWithInstructions withInstructions = new RoverWithInstructions();
                withInstructions.setRover(rover);
                withInstructions.setInstruction(instruction);
                withInstructions.setPlateau(plateau);

                roverWithInstructions.add(withInstructions);
            }
            return roverWithInstructions;

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Could not find file " + fileName);
        } catch (IOException exp) {
            throw new IOException("Error reading file " + fileName);
        }
    }

    private Position extractMaxPosition(String firstLine) {
        Position result = new Position();
        String[] listCoordinates = firstLine.split(" ");
        if (listCoordinates.length == 2) {
            int x;
            int y;
            try {
                x = Integer.parseInt(listCoordinates[0]);
                y = Integer.parseInt(listCoordinates[1]);
            } catch (NumberFormatException exp) {
                throw new NumberFormatException("Error during parsing value of the line");
            }
            result.setX(x);
            result.setY(y);
            return result;
        } else if (listCoordinates.length < 2) {
            throw new RuntimeException("We have less than two coordinates on the first line");
        } else {
            throw new RuntimeException("We have more than two coordinates on the first line");
        }
    }

    private Rover createRover(String line) {
        String[] coordinatesAndOrientation = line.split(" ");
        if (coordinatesAndOrientation.length == 3) {
            int positionX;
            int positionY;
            Rover rover = new Rover();
            try {
                positionX = Integer.parseInt(coordinatesAndOrientation[0]);
                positionY = Integer.parseInt(coordinatesAndOrientation[1]);
                Position position = new Position(positionX, positionY);
                rover.setPosition(position);
            } catch (NumberFormatException number) {
                throw new NumberFormatException("Error during parsing value of the line");
            }
            String orientation = coordinatesAndOrientation[2];
            Orientation guidance;
            try {
                guidance = Orientation.valueOf(orientation);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid orientation for this line");
            }
            rover.setOrientation(guidance);
            return rover;
        } else {
            throw new RuntimeException("Invalid entries for this line to extract position and orientation ");
        }
    }

    private String createInstruction(String line) {
        return line.trim();
    }

}
