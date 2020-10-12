package prueba.zemsania.demo.service;

import java.util.List;

import prueba.zemsania.demo.model.producto;;

public interface productoService {

	List<producto> getAllProductos();
	
	void saveProducto(producto product) throws Exception;
	
	void deleteProducto(int idProducto) throws Exception;
	
	producto getProducto(int idProducto) throws Exception;
	
	void updateProducto(producto product) throws Exception;
	
}
