package api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.ProductModel;

@Path("/products")
public interface ProductService {
	
	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	void addProduct(ProductModel product);
	
	@GET
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	ProductModel findByCodigo(int codigo);
	
	@GET
	@Path("/products")
	@Consumes(MediaType.APPLICATION_JSON)
	List<ProductModel> listAllProducts();
	
	@PUT
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	void updateProduct(ProductModel product);
	
	

}
