package com.example.casestudy.services;

import com.example.casestudy.libs.DBConnection;
import com.example.casestudy.models.Categories;
import com.mysql.cj.protocol.Resultset;
import jdk.jfr.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    DBConnection dbConnection = new DBConnection();
    public void addCategory(Categories category) {
        String SQL = "INSERT INTO categories (name,description) VALUES (?,?)";

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);)
        {
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Categories> getAllCategories() {
        List<Categories> categories = new ArrayList<>();
        String SQL = "SELECT * FROM categories";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);)
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Categories category = new Categories();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Categories category1 = new Categories(id,name,description);
                categories.add(category1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public Categories getCategoryById(int id) {
        String SQL = "SELECT * FROM categories WHERE id = ?";
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);)
        {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int currentId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Categories category1 = new Categories(id,name,description);
                return category1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void updateCategory(Categories category) {
        String SQL = "UPDATE categories SET name = ?, description = ? WHERE id = ?";

        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getDescription());
            preparedStatement.setInt(3,category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteCategory(int id) {
        String SQL = "DELETE FROM categories WHERE id = ?";

        try(Connection conn = dbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);) {
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM categories WHERE name = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
