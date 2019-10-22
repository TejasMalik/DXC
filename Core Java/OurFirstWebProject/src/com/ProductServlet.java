package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.pms.doa.ProductDAO;
import com.dxc.pms.doa.ProductDAOImpl;
import com.dxc.pms.model.Product;

public class ProductServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		response.getWriter().println(productId);
		
//		Product product = new Product(productId, productName, quantity, price);
//		ProductDAO productDAO = new ProductDAOImpl();
//		productDAO.addProduct(product);

		
	}

}
