package fr.sijo.bnp.service;

import fr.sijo.bnp.model.Rover;

public class RotateRightCommandService implements ICommandService {

    @Override
    public void execute(Rover rover) {
        rover.rotateRight();
    }
}
