package com.dxc.pms.doa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pms.client.Main;
import com.dxc.pms.jdbc.DBConnection;
import com.dxc.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {

	Connection connection = DBConnection.getConnection();
	private static final String FETCH_ALL_PRODUCTS = "SELECT * FROM producttable";

	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Product product = new Product();
		try {
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM producttable WHERE Product ID =" + productId);
			if (res.next()) {
				product.setProductId(res.getInt(1));
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
			} else {
				System.out.println("Record Not Found.....");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<Product>();
		// TODO Auto-generated method stub
		try {
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(FETCH_ALL_PRODUCTS);
			while (res.next()) {
				Product product = new Product();
				product.setProductId(res.getInt(1));
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
				allProducts.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allProducts;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstat = connection.prepareStatement("INSERT INTO producttable VALUES (?,?,?,?)");
			pstat.setInt(1, product.getProductId());
			pstat.setString(2, product.getProductName());
			pstat.setInt(3, product.getQuantityOnHand());
			pstat.setInt(4, product.getPrice());

			pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

}
