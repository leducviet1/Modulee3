package com.example.thuchanh1808.services;

import com.example.thuchanh1808.libs.DBConnection;
import com.example.thuchanh1808.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    DBConnection dbConnection = new DBConnection();
    public void add(Employee employee) {
        //SQL(Insert into)
        //result set đại diện các bản ghi
        String SQL = "INSERT INTO employees(full_name,email,phone,department_id) VALUES (?,?,?,?)";
//Đảm bảo có kết nối

        //Thực thi prepared statement
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ){
            statement.setString(1, employee.getfullName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            if(employee.getDepartmentId()==0){
                statement.setNull(4, java.sql.Types.INTEGER);
            }else{
                statement.setInt(4, employee.getDepartmentId());
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Employee employee) {

            //SQL(Insert into)
            //result set đại diện các bản ghi
            String SQL = "UPDATE employees SET full_name=?,email=?,phone=?,department_id=? WHERE id=?";
//Đảm bảo có kết nối

            //Thực thi prepared statement
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement statement = conn.prepareStatement(SQL);
            ){
                statement.setString(1, employee.getfullName());
                statement.setString(2, employee.getEmail());
                statement.setString(3, employee.getPhone());
                statement.setString(4, employee.getDepartmentName());
                statement.setInt(5, employee.getId());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
    //Sửa lại : bổ sung thêm tham số q
    public List<Employee> getAll(String q, String sortBy, String filteredDepartmentId) {
        List<Employee> employees = new ArrayList<>();
        String SQL = "SELECT e.id, e.full_name, e.email, e.phone, e.department_id, d.name AS department_name FROM employees e LEFT JOIN departments d ON e.department_id=d.id";
        if (q != null && !q.isEmpty()) {
            SQL = SQL + " WHERE full_name LIKE '%" + q + "%' OR email LIKE '%" + q + "%'";
        }
        if(filteredDepartmentId != null && !filteredDepartmentId.isEmpty()) {
            if(q != null && !q.isEmpty()) {
                SQL += " AND ";
            }else{
                SQL += " WHERE ";
            }
            SQL = SQL + " department_id = " + filteredDepartmentId + "";
        }
        if (sortBy != null && !sortBy.isEmpty()) {
            SQL = SQL + " ORDER BY " + sortBy;
        }
        try(
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ){
           ResultSet rs = statement.executeQuery();
           while (rs.next()) {
               int id = rs.getInt("id");
               String fullName = rs.getString("full_name");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               int departmentId = rs.getInt("department_id");
               String departmentName = rs.getString("department_name");
               Employee employee = new Employee(id,fullName,email,phone, departmentName);
               employees.add(employee);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public Employee getById(int id) {
        String SQL = "SELECT e.id, e.full_name, e.email, e.phone, e.department_id, d.name AS department_name FROM employees e LEFT JOIN departments d ON e.department_id=d.id where e.id=?";
        try(
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int currentId = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Employee employee = new Employee(currentId,fullName,email,phone, departmentName);
                return employee;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public int delete(int id) {
        String SQL = "DELETE FROM employees WHERE id = ?";
        try(
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ){
            statement.setInt(1, id);
            int result = statement.executeUpdate(); //so row bị ảnh hưởng
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
