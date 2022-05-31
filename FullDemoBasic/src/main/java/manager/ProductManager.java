package manager;

import java.util.ArrayList;

import dao.ProductDAO;
import entity.Product;

public class ProductManager {

	private ArrayList<Product> listProducts;
	private ProductDAO myProductDAO;

	public ProductManager() {

		this.listProducts = new ArrayList();
		myProductDAO = new ProductDAO();
	}

	public ProductManager(ArrayList<Product> listProduct) {

		this.listProducts = listProduct;
		myProductDAO = new ProductDAO();
	}

	public Product getProductByID(String id) {
		Product resProduct = null;
		for (int i = 0; i < this.listProducts.size(); i++) {
			Product currentProduct = listProducts.get(i);
			if (currentProduct.getProductID().equalsIgnoreCase(id)) {
				return currentProduct;
			}
		}
		return resProduct;
	}

	public boolean addProduct(Product product) {
		boolean result = false;
//		String id = product.getProductID();
//		Product foundProduct = this.getProductByID(id);
//		if (foundProduct == null) {
//
//		}
		if (this.getProductByID(product.getProductID()) == null) {
			this.listProducts.add(product);
			result = true;
		}
		return result;
	}

	public boolean deleteProductByID(String id) {
		boolean result = false;

		Product foundProduct = this.getProductByID(id);
		if (foundProduct != null) {
			this.listProducts.remove(foundProduct);
			result = true;
		}
		return result;
	}

	public ArrayList getListProduct() {
		return this.listProducts;
	}

	public ArrayList getProductByName(String name) {
		ArrayList resultProductList = new ArrayList<>();

		Product tempProduct;
		for (int i = 0; i < listProducts.size(); i++) {
			tempProduct = listProducts.get(i);
			if (tempProduct.getProductName().contains(name.toLowerCase())) {
				resultProductList.add(tempProduct);
			}
		}
		return resultProductList;
	}

	public ArrayList getProductByTitle(String title) {
		ArrayList resultProductList = new ArrayList<>();

		Product tempProduct;
		for (int i = 0; i < listProducts.size(); i++) {
			tempProduct = listProducts.get(i);
			if (tempProduct.getTitle().contains(title.toLowerCase())) {
				resultProductList.add(tempProduct);
			}
		}
		return resultProductList;
	}

	public ArrayList getProductByQuantity(int quantity) {
		ArrayList resultProductList = new ArrayList<>();

		Product tempProduct;
		for (int i = 0; i < listProducts.size(); i++) {
			tempProduct = listProducts.get(i);
			if (tempProduct.getQuantity() == quantity) {
				resultProductList.add(tempProduct);
			}
		}
		return resultProductList;
	}

	public boolean updateProduct(Product edditedProduct) {
		boolean result = false;
		Product oldProduct;
		oldProduct = this.getProductByID(edditedProduct.getProductID());
		if (oldProduct != null) {
			int i = this.listProducts.indexOf(oldProduct);
			this.listProducts.remove(i);
			this.listProducts.add(i, edditedProduct);
			result = true;
		}
		return result;
	}

	public int saveByteData() {
		this.myProductDAO.saveListProductAsByte(this.listProducts);
		return this.listProducts.size();
	}

	public int saveCharData() {
		this.myProductDAO.saveListProductAsChar(this.listProducts);
		return this.listProducts.size();
	}

	public int getByteData() {
		this.listProducts = this.myProductDAO.readListProductAsByte();
		if (this.listProducts == null) {
			this.listProducts =new ArrayList<Product>();
		}
		return this.listProducts.size();
	}
}
