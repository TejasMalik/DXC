package Core_Java;

import java.util.Scanner;

public class ProductgetID {

	private int productId;
	private String productName;
	private int quantityOnhand;
	private int price;

	public ProductgetID() {
		productName = "Product Name not available";
	}

	public ProductgetID(int productId, String productName, int quantityOnhand, int price) {
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
		ProductgetID[] product = new ProductgetID[5];
		product[0] = new ProductgetID(100, "Mobile", 1, 66000);
		product[1] = new ProductgetID(101, "Laptop", 1, 78000);
		product[2] = new ProductgetID(102, "TV", 1, 100000);
		product[3] = new ProductgetID(103, "Chocolates", 50, 1000);
		product[4] = new ProductgetID(104, "Chips", 100, 2000);

		int pId = s.nextInt();

		for (int i = 0; i < product.length; i++) {
			int checkId = product[i].getProductId();

			if (checkId == pId) {
				System.out.println(product[i].toString());
				return;
			}
		}
		System.out.println("Product Id does not exist.");
	}

}
