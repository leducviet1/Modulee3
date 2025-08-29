package com.example.thuchanh1808.services;

import com.example.thuchanh1808.models.Department;
import com.example.thuchanh1808.libs.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    DBConnection dbConnection = new DBConnection();

    public void add(Department department) {
        //SQL(Insert into)
        //result set đại diện các bản ghi
        String SQL = "INSERT INTO departments(name,description) VALUES (?,?)";
//Đảm bảo có kết nối

        //Thực thi prepared statement
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL);
        ){
            statement.setString(1, department.getName());
            statement.setString(2, department.getDescription());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Department department) {
        String SQL = "UPDATE departments SET name=?,description=? WHERE id=?";

        try ( Connection conn = dbConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);
        ) {

            statement.setString(1, department.getName());
            statement.setString(2, department.getDescription());
            statement.setInt(3, department.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        String SQL = "SELECT * FROM departments";
        try (Connection conn = dbConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Department department1 = new Department(id, name, description);
                departments.add(department1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public Department getById(int id) {
        String SQL = "SELECT * FROM departments WHERE id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int currentId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Department department1 = new Department(currentId, name, description);
                return department1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }
    public int  deleteById(int id) {
        String SQL = "DELETE FROM departments WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            statement.setInt(1, id);
            int rs = statement.executeUpdate();
            return rs;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
