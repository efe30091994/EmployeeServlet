package services;

import entity.ProgrammerEntity;
import models.ProgrammerDto;

import java.sql.SQLException;
import java.util.List;

public interface IProgrammerService {
    void addProgrammer(ProgrammerEntity programmerEntity);

    ProgrammerEntity readProgrammer(int id) throws SQLException;

    List<ProgrammerEntity> readProgrammers() throws SQLException;

    void deleteProgrammer(String name);

    void updateProgrammer(ProgrammerEntity programmerEntity, String name);

}
