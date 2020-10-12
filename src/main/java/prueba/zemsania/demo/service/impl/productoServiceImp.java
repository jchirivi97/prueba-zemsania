package prueba.zemsania.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.zemsania.demo.model.producto;
import prueba.zemsania.demo.repository.productoRepository;
import prueba.zemsania.demo.service.productoService;

@Service
public class productoServiceImp implements productoService {

	@Autowired
	productoRepository productRepository;
	
	
	@Override
	public List<producto> getAllProductos() {
		return productRepository.findAll();
	}

	@Override
	public void saveProducto(producto product) throws Exception {
		if(product.equals(getProducto(product.getIdProducto()))){
			throw new Exception("Producto Existe");
		}else{
			productRepository.save(product);
		}
				
	}

	@Override
	public void deleteProducto(int idProducto) {
		productRepository.deleteById(idProducto);
	}

	@Override
	public producto getProducto(int idProducto) {
		return productRepository.findById(idProducto).get();
	}

	@Override
	public void updateProducto(producto product) {
		productRepository.updateProduct(product.getIdProducto(), product.getNombre(), product.getPrecio());
	}

	
}
