package fr.sijo.bnp;

import fr.sijo.bnp.model.RoverWithInstructions;
import fr.sijo.bnp.service.MarsRoverService;
import fr.sijo.bnp.service.input.FileInputService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class RoverMain {

    private static final Logger logger = Logger.getLogger(RoverMain.class.getName());

    public static void main(String[] args) throws IOException {

        MarsRoverService marsRoverService = new MarsRoverService();
        checkInputFileArgument(args);
        String inputFile = args[0];
        checkFileNameAndExtension(inputFile);
        checkNumberLines(inputFile);
        FileInputService fileInputService = new FileInputService(inputFile);
        List<RoverWithInstructions> roverWithInstructions;
        try {
            roverWithInstructions = fileInputService.parseFileAndExtractData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException exp) {
            throw new RuntimeException(exp);
        }

        for (RoverWithInstructions roverAndInsTructions : roverWithInstructions) {
            marsRoverService.executeCommand(roverAndInsTructions.getRover(), roverAndInsTructions.getInstruction());
            if (!roverAndInsTructions.getPlateau().isValidPosition(roverAndInsTructions.getRover().getPosition())) {
                throw new RuntimeException("Invalid position,the new position of rover is outside the plateau");
            }
            System.out.println(roverAndInsTructions.getRover());
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

    private static void checkNumberLines(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] lines = br.lines().toArray(String[]::new);
            if ((lines.length - 1) % 2 != 0) {
                throw new RuntimeException("Incorrect number of line in the input file");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Could not find file " + fileName);
        } catch (IOException exp) {
            throw new IOException("Error reading file " + fileName);
        }
    }

}