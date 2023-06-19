package fr.sijo.bnp;

import fr.sijo.bnp.model.Orientation;
import fr.sijo.bnp.model.Position;
import fr.sijo.bnp.model.Rover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RoverMain {

    private static final Logger logger = Logger.getLogger(RoverMain.class.getName());
    public static void main(String[] args) throws FileNotFoundException {

        checkInputFileArgument(args);
        String inputFile = args[0];
        checkFileNameAndExtension(inputFile);

        Position maxPosition;
        List<Rover> roverList = new ArrayList<>();
        List<String> instructions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String[] lines = br.lines().toArray(String[]::new);
            checkNumberLines(lines.length);
            String line1 = lines[0];
            maxPosition = extractMaxPosition(line1);

            for (int i = 1; i < lines.length; i++) {
                String nextLine = lines[i];
                if (i % 2 != 0) {
                    Rover rover = createRover(nextLine);
                    roverList.add(rover);
                } else {
                    String instruct = createInstruction(nextLine);
                    instructions.add(instruct);
                }
            }

            for (int i = 0; i < roverList.size(); i++) {
                Rover rover = roverList.get(i);
                String instruction = instructions.get(i);
                rover.executeCommand(instruction, maxPosition);
                System.out.println(rover);
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Could not find file" + inputFile);
        } catch (IOException exp) {
            throw new FileNotFoundException("Error reading file" + inputFile);
        }

    }

    private static void checkInputFileArgument(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Please provide the input file as argument.");
        } else if (args.length > 1) {
            logger.info("More than two argument provide we are going to use just the first arg");
        }
    }

    private static void checkFileNameAndExtension(String inputFile) {
        String[] fileNameExtension = inputFile.split("\\.");
        if (fileNameExtension.length == 2) {
            if (!"txt".equals(fileNameExtension[1])) {
                throw new RuntimeException("Bad file extension, the input file will have this extension .txt");
            }
        } else {
            throw new RuntimeException("Bad file extension, the input file will have this extension .txt");
        }
    }

    private static void checkNumberLines(int numberLine) {
        if ((numberLine - 1) % 2 != 0) {
            throw new RuntimeException("Incorrect number of line in the input file");
        }
    }

    private static Rover createRover(String line) {
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
            Orientation guidance = Orientation.valueOf(orientation);
            if (guidance == null) {
                throw new RuntimeException("Invalid orientation for this line");
            }
            rover.setOrientation(guidance);
            return rover;
        } else {
            throw new RuntimeException("Invalid entries for this line to extract position and orientation ");
        }
    }

    private static String createInstruction(String line) {
        return line.trim();
    }

    public static Position extractMaxPosition(String firstLine) {
        Position result = new Position();
        String[] listCoordinates = firstLine.split(" ");
        if (listCoordinates.length == 2) {
            //Error during parsing handle it
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

}