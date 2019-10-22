package com.dxc.pms.doa;

import java.util.ArrayList;
import java.util.List;

import com.dxc.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	List<Product> allProducts = new ArrayList<Product>();

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Product product = allProducts.stream().filter(n -> n.getProductId() == productId).findFirst().get();
		return product;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return allProducts;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		allProducts.add(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		allProducts.removeIf(g -> g.getProductId() == productId);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		for (int i = 0; i<allProducts.size(); i++) {
			if (product.getProductId() == allProducts.get(i).getProductId()) {
				allProducts.set(i, product);
			}
		}

	}

}
