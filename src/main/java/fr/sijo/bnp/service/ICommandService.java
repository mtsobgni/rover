package fr.sijo.bnp.service;

import fr.sijo.bnp.model.Rover;

public interface ICommandService {

    void execute(Rover rover);
}
