package com.food.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderDAO;
import com.food.model.Order;

public class OrderDAOImpl implements OrderDAO {

	private static final String INSERT_QUERY = "INSERT INTO `ordertable` (`OrderID`, `UserID`, `RestaurantID`, `OrderDate`, `TotalAmount`, `Status`, `PaymentMethod`) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE `ordertable` SET `UserID`=?, `RestaurantID`=?, `OrderDate`=?,  `TotalAmount`=?,  `Status`=?,  `PaymentMethod`=? WHERE (`OrderID`=?)";
	private static final String DELETE_QUERY = "DELETE FROM `ordertable` WHERE (`OrderID`=?)";
	private static final String SELECT_QUERY = "SELECT * FROM `ordertable` WHERE (`OrderID`=?)";
	private static final String SELECTALL_QUERY = "SELECT * FROM `ordertable` WHERE (`UserID`=?) ";

	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static ResultSet res;

	public OrderDAOImpl() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(Order order) {

		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			
			prepareStatement.setInt(1, order.getOrderId());
			prepareStatement.setInt(2, order.getUserId());
			prepareStatement.setInt(3, order.getRestaurantId());
			prepareStatement.setDate(4, order.getOrderDate());
			prepareStatement.setDouble(5, order.getTotalAmount());
			prepareStatement.setString(6, order.getStatus());
			prepareStatement.setString(7, order.getPaymentMethod());

			int i = prepareStatement.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);// DELETE FROM `order` WHERE (`OrderID`=?)"
			prepareStatement.setInt(1, orderId);
			int i = prepareStatement.executeUpdate();
			System.out.println(i);
			
			String reset = "ALTER TABLE `ordertable` AUTO_INCREMENT = 1";
			prepareStatement.executeUpdate(reset);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order order) {

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setInt(1, order.getUserId());
			prepareStatement.setInt(2, order.getRestaurantId());
			prepareStatement.setDate(3, (java.sql.Date) order.getOrderDate());
			prepareStatement.setDouble(4, order.getTotalAmount());
			prepareStatement.setString(5, order.getStatus());
			prepareStatement.setString(6, order.getPaymentMethod());
			prepareStatement.setInt(7, order.getOrderId());

			int i = prepareStatement.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrder(int orderId) {

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);// SELECT * FROM `order` WHERE (`OrderID`=?);
			prepareStatement.setInt(1, orderId);
			res = prepareStatement.executeQuery();
			while (res.next()) {
				return new Order(res.getInt("OrderID"), res.getInt("UserID"), res.getInt("RestaurantID"),
						res.getDate("OrderDate"), res.getDouble("TotalAmount"), res.getString("Status"),
						res.getString("PaymentMethod"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getAllOrdersByUser(int userId) {

		List<Order> list = new ArrayList<Order>();

		try {
			prepareStatement = connection.prepareStatement(SELECTALL_QUERY);
			prepareStatement.setInt(1, userId);
			
			res = prepareStatement.executeQuery();
			

			while (res.next()) {
				Order u =new Order(res.getInt("OrderID"),res.getInt("UserID"),res.getInt("RestaurantID"),res.getDate("OrderDate")
						,res.getDouble("TotalAmount"),res.getString("Status"),res.getString("PaymentMethod"));
				
				list.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
