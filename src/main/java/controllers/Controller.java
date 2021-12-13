package controllers;

import entity.ProgrammerEntity;
import mappers.ProgrammerMapper;
import models.ProgrammerDto;
import services.IProgrammerService;
import services.impl.ProgrammerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet("/")
public class Controller extends HttpServlet {
    ProgrammerMapper programmerMapper = new ProgrammerMapper();
    IProgrammerService programmerService = new ProgrammerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            controllerGet(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controllerPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controllerPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        controllerDelete(req, resp);
    }

    public void controllerGet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String uri = req.getRequestURI();
        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();
        switch (uri) {
            case "/programmer":
                Integer id = Integer.parseInt(req.getParameter("id"));
                ProgrammerDto programmerDto = programmerMapper.mapperEntityToDto(programmerService.readProgrammer(id));
                printWriter.println(programmerMapper.mapperDtoToJson(programmerDto));
                break;
            case "/programmers":
                System.out.println("readProgrammers-----" + programmerService.readProgrammers());
                String json = programmerMapper.mapperEntityListToDtoList(programmerService.readProgrammers());
                printWriter.println(json);
                break;
        }
    }

    public void controllerPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/programmer":
                String json = req.getReader().lines().collect(Collectors.joining());
                ProgrammerDto programmerDto = programmerMapper.mapperJsonToDto(json);
                ProgrammerEntity programmerEntity = programmerMapper.mapperDtoToEntity(programmerDto);
                programmerService.addProgrammer(programmerEntity);
                break;
        }

    }

    public void controllerPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/programmer":
                String json = req.getReader().lines().collect(Collectors.joining());
                String name = req.getParameter("name");
                ProgrammerDto programmerDto = programmerMapper.mapperJsonToDto(json);
                ProgrammerEntity programmerEntity = programmerMapper.mapperDtoToEntity(programmerDto);
                programmerService.updateProgrammer(programmerEntity, name);
                break;
        }
    }

    public void controllerDelete(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/programmer":
                String name = req.getParameter("name");
                programmerService.deleteProgrammer(name);
                break;
        }
    }

}
