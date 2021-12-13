package services.impl;

import entity.ProgrammerEntity;
import repositories.ProgrammerRepository;
import services.IProgrammerService;

import java.sql.SQLException;
import java.util.List;

public class ProgrammerService implements IProgrammerService {
    ProgrammerRepository programmerRepository = new ProgrammerRepository();

    @Override
    public void addProgrammer(ProgrammerEntity programmerEntity) {
        programmerRepository.addProgrammer(programmerEntity);
    }

    @Override
    public ProgrammerEntity readProgrammer(int id) throws SQLException {
        return programmerRepository.getProgrammer(id);
    }

    @Override
    public List<ProgrammerEntity> readProgrammers() throws SQLException {
        return programmerRepository.getAllProgrammers();
    }

    @Override
    public void deleteProgrammer(String name) {
        programmerRepository.deleteProgrammer(name);
    }

    @Override
    public void updateProgrammer(ProgrammerEntity programmerEntity, String name) {
        programmerRepository.updateProgrammer(programmerEntity, name);
    }
}
