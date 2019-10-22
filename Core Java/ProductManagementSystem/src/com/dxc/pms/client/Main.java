package com.dxc.pms.client;

import java.util.Scanner;

import com.dxc.pms.doa.ProductDAO;
import com.dxc.pms.doa.ProductDAOImpl;
import com.dxc.pms.model.Product;

public class Main {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAOImpl();
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("MENU");
			System.out.println("1. Add The Products");
			System.out.println("2. Get All the Products");
			System.out.println("3. Exit");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter ProductID");
				int productId = s.nextInt();
				System.out.println("Enter Product Name");
				String productName = s.next();
				System.out.println("Enter Product Quantity");
				int quantityOnHand = s.nextInt();
				System.out.println("Enter Product price");
				int price = s.nextInt();

				Product product = new Product(productId, productName, quantityOnHand, price);
				productDAO.addProduct(product);
				break;

			case 2:
				System.out.println(productDAO.getAllProducts());
				break;

			case 3:
				System.exit(0);
			}
		}

	}
}
