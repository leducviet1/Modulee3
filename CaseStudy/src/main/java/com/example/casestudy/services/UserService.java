package com.example.casestudy.services;

import com.example.casestudy.libs.DBConnection;
import com.example.casestudy.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public User login(String username, String password) {
        String SQL = "select * from users where username=? AND password=? ";
        try(Connection conn= DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQL);){
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){

                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                String role1 = rs.getString("role");
                User user = new User(id,username1,password1,role1);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public boolean register(String username, String password) {
        String role = "user";
        String SQL = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            int rows = pstmt.executeUpdate();
            if(rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public List<User> getAllUsers() {
        String SQL = "SELECT id, username, password FROM users WHERE `role` = 'user'";
        List<User> users = new ArrayList<>();

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(id,username, password);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;

    }
    public User getUserById(Integer id) {
        String SQL = "select  u.username, u.password from users as u where id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(username, password);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public int deleteUser(int id) {
        String SQL = "delete from users where id=?";
        try(
                Connection conn = DBConnection.getConnection();
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

