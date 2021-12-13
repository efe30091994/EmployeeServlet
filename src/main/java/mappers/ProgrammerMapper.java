package mappers;

import com.google.gson.Gson;
import entity.ProgrammerEntity;
import models.ProgrammerDto;

import java.util.List;

public class ProgrammerMapper implements Mapper {

    Gson gson = new Gson();

    @Override
    public ProgrammerDto mapperJsonToDto(String json) {
        return gson.fromJson(json, ProgrammerDto.class);
    }

    @Override
    public ProgrammerEntity mapperDtoToEntity(ProgrammerDto dto) {
        String json = gson.toJson(dto);
        return gson.fromJson(json, ProgrammerEntity.class);
    }

    @Override
    public ProgrammerDto mapperEntityToDto(ProgrammerEntity entity) {
        String json = gson.toJson(entity);
        return gson.fromJson(json, ProgrammerDto.class);
    }

    @Override
    public String mapperDtoToJson(ProgrammerDto dto) {
        return gson.toJson(dto);
    }

    @Override
    public String mapperDtoListToJson(List<ProgrammerDto> dto) {
        return gson.toJson(dto);
    }


    @Override
    public String mapperEntityListToDtoList(List<ProgrammerEntity> programmerEntities) {
        String json = gson.toJson(programmerEntities);
        return json;
    }
}
