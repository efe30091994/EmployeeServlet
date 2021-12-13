package repositories;


import entity.ProgrammerEntity;
import util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgrammerRepository {
    Utils utils = new Utils();

    public ProgrammerEntity getProgrammer(Integer id) throws SQLException {
        Connection connection = utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from programmers where programmers.id=" + id);
            while (resultSet.next()) {
                ProgrammerEntity programmerEntity = new ProgrammerEntity();
                programmerEntity.setId(resultSet.getInt("id"));
                programmerEntity.setName(resultSet.getString("name"));
                programmerEntity.setAge(resultSet.getInt("age"));
                programmerEntity.setLevel(resultSet.getString("level"));
                return programmerEntity;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new SQLException("Its entity by " + id + " not found");

    }

    public List<ProgrammerEntity> getAllProgrammers() throws SQLException {
        Connection connection = utils.getConnection();
        try {
            List<ProgrammerEntity> listItems = new ArrayList<ProgrammerEntity>();;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM programmers");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String level = resultSet.getString("level");
                ProgrammerEntity programmerEntity = new ProgrammerEntity(id, name,age,level);
                listItems.add(programmerEntity);
            }
            return listItems;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new SQLException("No one was found");
    }

    public void addProgrammer(ProgrammerEntity programmerEntity) {
        Connection connection = utils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO programmers (name, age, level) VALUES ( ?, ?, ?)");
            preparedStatement.setString(1, programmerEntity.getName());
            preparedStatement.setInt(2, programmerEntity.getAge());
            preparedStatement.setString(3, programmerEntity.getLevel());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteProgrammer(String name) {
        Connection connection = utils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM programmers WHERE name = '" + name + "'");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateProgrammer(ProgrammerEntity programmerEntity, String name) {
        Connection connection = utils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE programmers SET name = '" + programmerEntity.getName()
                    + "', age = " + programmerEntity.getAge() + ", level = '" + programmerEntity.getLevel() + "' where name = '" + name + "'");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
