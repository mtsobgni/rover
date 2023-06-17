package fr.sijo.bnp;

import fr.sijo.bnp.model.Orientation;
import fr.sijo.bnp.model.Position;
import fr.sijo.bnp.model.RotateAndMove;
import fr.sijo.bnp.model.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Position maxPosition;
        List<Rover> roverList = new ArrayList<>();
        List<String> instructions = new ArrayList<>();
        String inputFile = "";
        //final String INPUT = "input.txt";

        if (args == null || args.length == 0) {
            throw new RuntimeException("Aucun parameter specifié");
        } else if (args.length > 1) {
            throw new RuntimeException("More than one param specified");
        } else {
            inputFile = args[0];
        }

        checkFileNameAndExtension(inputFile);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String [] lines = br.lines().toArray(String[]::new);
            checkNumberLines(lines.length);
            maxPosition = extractMaxPosition(lines[0]);

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
                for (char c : instruction.toCharArray()) {
                    if (RotateAndMove.CHAR_L.getValue() == c) {
                        rover.rotateLeft();
                    } else if (RotateAndMove.CHAR_R.getValue() == c) {
                        rover.rotateRight();
                    } else if (RotateAndMove.CHAR_M.getValue() == c) {
                        rover.moveForward();
                        if (!isValidPosition(maxPosition, rover.getPosition())) {
                            throw new RuntimeException("Invalid position,the new position of rover is outside the plateau");
                        }
                    } else {
                        throw new RuntimeException("Invalid instruction, the instruction will be a part of this list(L, R, M)");
                    }
                }
                System.out.println(rover);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkFileNameAndExtension(String inputFile) {
        if (!"input.txt".equals(inputFile)) {
                throw new RuntimeException("Bad file name or extension, the input file will be input.txt");
        }
    }

    private static void checkNumberLines(int numberLine) {
        if ((numberLine-1) % 2 != 0) {
            throw new RuntimeException("Incorrect number of line in the input file");
        }
    }

    private static Rover createRover(String line) {
        String[] coordinatesAndOrientation = line.split(" ");
        if (coordinatesAndOrientation.length == 3) {
            //Maybe error during parsing
            int positionX = Integer.parseInt(coordinatesAndOrientation[0]);
            int positionY = Integer.parseInt(coordinatesAndOrientation[1]);
            Rover rover = new Rover();
            Position position = new Position(positionX, positionY);
            rover.setPosition(position);
            String orientation = coordinatesAndOrientation[2];
           Orientation guidance = getOrientationValue(orientation);
            if (guidance == null) {
                throw new RuntimeException("Invalid orientation");
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

    private static Orientation getOrientationValue(String value) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.toString().equals(value)) {
                return orientation;
            }
        }
        return null;
    }

    public static boolean isValidPosition(Position posoMax, Position poso) {
        return poso.getX() >= 0 && poso.getX() <= posoMax.getX() && poso.getY() >= 0 && poso.getY() <= posoMax.getY();
    }

    public static Position extractMaxPosition(String firstLine) {
        Position result = new Position();
        String[] listCoordinates = firstLine.split(" ");
        if (listCoordinates.length == 2) {
            //Error during parsing handle it
            int x = Integer.parseInt(listCoordinates[0]);
            int y = Integer.parseInt(listCoordinates[1]);
            result.setX(x);
            result.setY(y);
        } else {
            throw new RuntimeException("We have more than two coordinates on the line");
        }
        return result;
    }

}