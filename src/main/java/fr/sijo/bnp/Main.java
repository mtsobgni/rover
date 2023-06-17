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
        Position maxPosition = new Position();
        List<Rover> roverList = new ArrayList<>();
        List<String> instructions = new ArrayList<>();

        //checkIf one param
        String parameter = "";
        if (args == null || args.length == 0) {
            throw new RuntimeException("Aucun parameter specifié");
        } else if (args.length > 1) {
            throw new RuntimeException("More than one param specified");
        } else {
            parameter = args[0];
        }
        //Suite

        // Extension and name file -> input.txt
        //checkIfFileIsGood();
        checkFileAndExtension(parameter);

        try (BufferedReader br = new BufferedReader(new FileReader(parameter))) {
            //List<String> list = br.lines().collect(Collectors.toList());
            String [] list = br.lines().toArray(String[]::new);
            checkModulo(list.length);
            String firstLine = list[0];
            String[] arrayMaxPosition = firstLine.split(" ");
            if (arrayMaxPosition.length == 2) {
                int firstNumber = Integer.parseInt(arrayMaxPosition[0]);  // Parse the first number
                int secondNumber = Integer.parseInt(arrayMaxPosition[1]);  // Parse the second number
                // Print the extracted numbers
                System.out.println("First number: " + firstNumber);
                System.out.println("Second number: " + secondNumber);
                maxPosition.setX(firstNumber);
                maxPosition.setY(secondNumber);
            } else {
                //System.out.println("Invalid input format");
                throw new RuntimeException("Invalid input format");
            }

            for (int i = 1; i < list.length; i++) {
                if (i % 2 != 0) {
                    String val = list[i];
                    Rover rover = createRover(val);
                    roverList.add(rover);
                } else {
                    String val = list[i];
                    String instruct = createOrCheckInstructiosn(val);
                    instructions.add(instruct);
                }
            }

            for (int i = 0; i < roverList.size(); i++) {
                Rover rover = roverList.get(i);
                String instruction = instructions.get(i);
                for (char c : instruction.toCharArray()) {
                    if (c == RotateAndMove.CHAR_L.getValue()) {
                        rover.rotateLeft();
                    } else if (c == RotateAndMove.CHAR_R.getValue()) {
                        rover.rotateRight();
                    } else if (c == RotateAndMove.CHAR_M.getValue()) {
                        rover.moveForward();
                        if (!isValidPosition(maxPosition, rover.getPosition())) {
                            throw new RuntimeException("Invalid position after move rover");
                        }
                    } else {
                        throw new RuntimeException("Invalid char ");
                    }
                }
                System.out.println(rover);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkFileAndExtension(String input) {
        if (input != null && input.length() > 2) {
            String[] result = input.split("\\.");
            if(!"input".equals(result[0]) || !"txt".equals(result[1])){
                throw new RuntimeException("Bad input file");
            }
        }
    }

    private static void checkFileAndExtension2(String input) {
        if (!"input.txt".equals(input)) {
                throw new RuntimeException("Bad input file");
        }
    }

    private static void checkModulo(int input) {
        if ((input-1) % 2 != 0) {
            throw new RuntimeException("Incorrect row of line");
        }
    }

    private static Rover createRover(String input) {
        String[] arrayPosiRover = input.split(" ");
        if (arrayPosiRover.length == 3) {
            int posiX = Integer.parseInt(arrayPosiRover[0]);  // Parse the first posi
            int posiY = Integer.parseInt(arrayPosiRover[1]);  // Parse the second posi// Parse the second posi
            String orientation = arrayPosiRover[2];
           Rover rover = new Rover();
           Position position = new Position(posiX, posiY);
           rover.setPosition(position);
           Orientation guidance = getOrientationValue(orientation);
           if(guidance == null){
               throw new RuntimeException("Invalid Orientation");
           }
           rover.setOrientation(guidance);
           return rover;
        } else {
            //System.out.println("Invalid input format");
            throw new RuntimeException("Invalid input format");
        }
    }

    private static String createOrCheckInstructiosn(String val) {
        return val.trim();
    }

    private static Orientation getOrientationValue(String val) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.toString().equalsIgnoreCase(val)) {
                return orientation;
            }
        }
        return null;
    }

    public static boolean isValidPosition(Position posoMax, Position poso) {
        return poso.getX() >= 0 && poso.getX() <= posoMax.getX() && poso.getY() >= 0 && poso.getY() <= posoMax.getY();
    }

}