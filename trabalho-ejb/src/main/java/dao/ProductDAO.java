package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Product;

@Stateless
public class ProductDAO {
	
	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;
	
	public void insert(Product product) {
		em.persist(product);
	}
	
	public List<Product> listAll(){
		TypedQuery<Product> q = em.createQuery("select p from Product p",Product.class);
		return q.getResultList();
	}
	
	public Product findByCod(int id) {
		Product product = em.find(Product.class,id);
		return product;
	}
	
	public void updateProduct(Product product) {
		em.persist(product);
	}

}
