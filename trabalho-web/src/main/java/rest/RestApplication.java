package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import interfaces.ProductServiceImpl;

@ApplicationPath("/api")
public class RestApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ProductServiceImpl.class);
		return classes;
	}

}
