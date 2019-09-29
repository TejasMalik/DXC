package Core_Java;

import java.util.Scanner;

public class Product {

	private int productId;
	private String productName;
	private int quantityOnhand;
	private int price;

	public Product() {
		productName = "Product Name not available";
	}

	public Product(int productId, String productName, int quantityOnhand, int price) {
		this.productId = productId;
		this.productName = productName;
		this.quantityOnhand = quantityOnhand;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityOnhand() {
		return quantityOnhand;
	}

	public void setQuantityOnhand(int quantityOnhand) {
		this.quantityOnhand = quantityOnhand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {

		return "Product [productId=" + productId + ", productName=" + productName + ", quantityOnhand=" + quantityOnhand
				+ ", price=" + price + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Product product[] = new Product[5];
		for (int i = 0; i < product.length; i++) {
			System.out.println("Enter the Product Details: " + (i + 1));
			int pId = s.nextInt();
			String pName = s.next();
			int qOnHand = s.nextInt();
			int priceOfProduct = s.nextInt();
			if (pId < 0 || qOnHand < 0 || priceOfProduct < 0) {
				System.out.println("Negative numbers are not allowed, Enter again");
				i--;
				continue;
			}
			product[i] = new Product(pId, pName, qOnHand, priceOfProduct);
			System.out.println("*******************************************************");
		}
		for (int i = 0; i < product.length; i++) {
			System.out.println(product[i].toString());
		}
	}

}
