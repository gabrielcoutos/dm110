package interfaces;

import java.util.List;

import model.ProductModel;

public interface Product {
	
	void addProduct(ProductModel product);
	
	ProductModel findByCodigo(int codigo);
	
	List<ProductModel> listAllProducts();
	
	void updateProduct(ProductModel product);

}
