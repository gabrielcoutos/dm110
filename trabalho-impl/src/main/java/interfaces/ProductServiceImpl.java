package interfaces;
import java.util.List;

import javax.ejb.EJB;

import api.ProductService;
import interfaces.ProductRemote;
import model.ProductModel;

public class ProductServiceImpl implements ProductService {
	
	@EJB(lookup = "ejb:trabalho-ear-1.0/trabalho-ejb-1.0/ProductBean!interfaces.ProductRemote")
	private ProductRemote productBean;

	@Override
	public void addProduct(ProductModel product) {
		productBean.addProduct(product);

	}

	@Override
	public ProductModel findByCodigo(int codigo) {
		return productBean.findByCodigo(codigo);
	}

	@Override
	public List<ProductModel> listAllProducts() {
		// TODO Auto-generated method stub
		return productBean.listAllProducts();
	}

	@Override
	public void updateProduct(ProductModel product) {
		productBean.updateProduct(product);

	}

}
