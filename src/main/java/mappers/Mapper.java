package mappers;

import entity.ProgrammerEntity;
import models.ProgrammerDto;

import java.util.List;

public interface Mapper {

    ProgrammerDto mapperJsonToDto(String json);

    ProgrammerEntity mapperDtoToEntity(ProgrammerDto dto);

    ProgrammerDto mapperEntityToDto(ProgrammerEntity entity);

    String mapperDtoToJson(ProgrammerDto dto);

    String mapperDtoListToJson(List<ProgrammerDto> programmerDto);

    String mapperEntityListToDtoList(List<ProgrammerEntity> readProgrammers);
}
