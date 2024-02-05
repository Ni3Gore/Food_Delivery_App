package com.food.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

	final private static String INSERT_QUERY = "INSERT INTO `orderitem`(`OrderID`,`MenuID`,`Quantity`,`ItemTotal`)values(?,?,?,?)";
	final private static String DELETE_QUERY = "DELETE FROM `orderitem` WHERE (`OrderItemID` = ?) ";
	final private static String UPDATE_QUERY = "UPDATE `orderitem` SET `OrderID`=?,`MenuID`=?,`Quantity`=?,`ItemTotal`=? ";
	final private static String SELECT_QUERY = "SELECT * FROM `orderitem` WHERE(`OrderItemID`=?)";
	final private static String SELECT_ALLQUERY = "SELECT * FROM `orderitem`";

	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static ResultSet resultSet;
	private static Statement statement;

	public OrderItemDAOImpl() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_app", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addOrderItem(OrderItem orderitem) {

		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
//			prepareStatement.setInt(1, orderitem.getOrderItemId());
			prepareStatement.setInt(1, orderitem.getOrderId());
			prepareStatement.setInt(2, orderitem.getMenuId());
			prepareStatement.setInt(3, orderitem.getQuantity());
			prepareStatement.setDouble(4, orderitem.getItemTotal());

			int i = prepareStatement.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItem(int orderItemId) {

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, orderItemId);
			int i = prepareStatement.executeUpdate();
			String reset = "ALTER TABLE `restaurant` AUTO_INCREMENT = 1";
			prepareStatement.executeUpdate(reset);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateOrderItem(OrderItem orderitem) {

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setInt(1, orderitem.getOrderId());
			prepareStatement.setInt(2, orderitem.getMenuId());
			prepareStatement.setInt(3, orderitem.getQuantity());
			prepareStatement.setDouble(4, orderitem.getItemTotal());
			int i = prepareStatement.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderItem getOrderItem(int orderitemId) {

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, orderitemId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				return new OrderItem(resultSet.getInt("orderitemId"), resultSet.getInt("OrderID"),
						resultSet.getInt("MenuID"), resultSet.getInt("Quantity"), resultSet.getDouble("ItemTotal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrder(int orderId) {
		List<OrderItem> orderlist = new ArrayList<OrderItem>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALLQUERY);
			while (resultSet.next()) {

				OrderItem orderItem = new OrderItem(resultSet.getInt("orderitemId"), resultSet.getInt("OrderID"),
						resultSet.getInt("MenuID"), resultSet.getInt("Quantity"), resultSet.getDouble("ItemTotal"));

				orderlist.add(orderItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderlist;
	}

}
