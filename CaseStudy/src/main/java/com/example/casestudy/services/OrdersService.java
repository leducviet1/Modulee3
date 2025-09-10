package com.example.casestudy.services;

import com.example.casestudy.libs.DBConnection;
import com.example.casestudy.models.Orders;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersService {
    DBConnection dbConnection = new DBConnection();
    public void addOrders(Orders orders){
        String SQL = "INSERT INTO orders(name,price,image,description,order_status,category_id) VALUES (?,?,?,?,?,?)";

        try (Connection conn = dbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
        ){
            preparedStatement.setString(1, orders.getName());
            preparedStatement.setBigDecimal(2, orders.getPrice());
            preparedStatement.setString(3, orders.getImage());
            preparedStatement.setString(4, orders.getDescription());
            preparedStatement.setString(5, orders.getOrderStatus());
            if(orders.getCategoryId()==0){
                preparedStatement.setNull(6,java.sql.Types.INTEGER);
            }else{
                preparedStatement.setInt(6, orders.getCategoryId());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateOrders(Orders orders){
        String SQL = "UPDATE orders SET name=?,price=?,image=?,description=?,category_id=?,order_status=? WHERE id=?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL);
        ){
            preparedStatement.setString(1, orders.getName());
            preparedStatement.setBigDecimal(2, orders.getPrice());
            preparedStatement.setString(3, orders.getImage());
            preparedStatement.setString(4, orders.getDescription());
            preparedStatement.setInt(5, orders.getCategoryId());
            preparedStatement.setString(6, orders.getOrderStatus());

            preparedStatement.setInt(7, orders.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Orders> getAllOrders(String q, String sortBy, String categoryId,String sortOrder) {
        List<Orders> orders = new ArrayList<>();
        String SQL = "SELECT o.id, o.name, o.price, o.image, o.description,o.category_id, o.order_status, c.name AS categories_name FROM orders o LEFT JOIN categories c ON o.category_id=c.id ";
        if (q != null && !q.isEmpty()) {
            SQL = SQL + " WHERE o.name LIKE '%" + q + "%' OR o.description  LIKE '%" + q + "%'";
        }
        if(categoryId != null && !categoryId.isEmpty()) {
            if(q != null && !q.isEmpty()) {
                SQL += " AND ";
            }else{
                SQL += " WHERE ";
            }
            SQL = SQL + " o.category_id = " + categoryId + "";
        }
        if (sortBy != null && !sortBy.isEmpty()) {
            SQL = SQL + " ORDER BY " + sortBy;
            if(sortOrder != null && !sortOrder.isEmpty()) {
                SQL = SQL + " " + sortOrder;
            }
        }

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL);
             ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            BigDecimal price = resultSet.getBigDecimal("price");
            String image = resultSet.getString("image");
            String description = resultSet.getString("description");
            int category_id = resultSet.getInt("category_id");
            String orderStatus = resultSet.getString("order_status");
            String categories_name = resultSet.getString("categories_name");
            Orders order = new Orders(id, name, price, image, description, orderStatus,categories_name);
            orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public Orders getById(int id){
        String SQL = "SELECT o.id, o.name, o.price, o.image, o.description,o.category_id, o.order_status, c.name AS categories_name FROM orders o LEFT JOIN categories c ON o.category_id=c.id where o.id=?;";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int currentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                String orderStatus = resultSet.getString("order_status");
                String category_name = resultSet.getString("categories_name");
                int categoryId = resultSet.getInt("category_id");
                Orders order = new Orders(currentId, name, price, image, description,category_name, orderStatus);
                order.setCategoryId(categoryId);
                return order;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public int deleteById(int id){
        String SQL = "DELETE FROM orders WHERE id=?";
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
