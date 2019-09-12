package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.ProductDAO;
import entity.Product;
import interfaces.ProductLocal;
import interfaces.ProductRemote;
import mdb.ProductSender;
import model.ProductModel;


@Stateless
@Remote(ProductRemote.class)
@Local(ProductLocal.class)
public class ProductBean implements ProductLocal,ProductRemote{
	
	@EJB
	private ProductDAO dao;
	
	@EJB
	private ProductSender sender;

	@Override
	public void addProduct(ProductModel product) {
		Product p = new Product();
		p.setCodigo(product.getCodigo());
		p.setCategoria(product.getCategoria());
		p.setDescricao(product.getDescricao());
		p.setNome(product.getNome());
		p.setPreco(p.getPreco());
		dao.insert(p);
		sender.sendMensage(product);
	}

	@Override
	public ProductModel findByCodigo(int codigo) {
		ProductModel pm = new ProductModel();
		Product p = dao.findByCod(codigo);
		pm.setCodigo(p.getCodigo());
		pm.setCategoria(p.getCategoria());
		pm.setDescricao(p.getDescricao());
		pm.setNome(p.getNome());
		pm.setPreco(p.getPreco());
		return pm;
	}

	@Override
	public List<ProductModel> listAllProducts() {
		ArrayList<ProductModel> list = new ArrayList<ProductModel>();
		for(Product p : dao.listAll()) {
			ProductModel pm = new ProductModel();
			pm.setCodigo(p.getCodigo());
			pm.setCategoria(p.getCategoria());
			pm.setDescricao(p.getDescricao());
			pm.setNome(p.getNome());
			pm.setPreco(p.getPreco());
			list.add(pm);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void updateProduct(ProductModel product) {
		Product p = new Product();
		p.setCodigo(product.getCodigo());
		p.setCategoria(product.getCategoria());
		p.setDescricao(product.getDescricao());
		p.setNome(product.getNome());
		p.setPreco(p.getPreco());
		dao.updateProduct(p);
	}

}
