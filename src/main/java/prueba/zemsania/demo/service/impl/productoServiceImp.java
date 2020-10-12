package prueba.zemsania.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

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
			throw new Exception("Este producto ya existe");
		}else{
			productRepository.save(product);
		}
				
	}

	@Override
	public void deleteProducto(int idProducto) throws Exception {
		try {
            java.util.Optional<producto> producto = productRepository.findById(idProducto);
            if (producto.isPresent()) {
            	productRepository.deleteById(idProducto);
            }
        } catch (Exception ex) {
            throw new Exception("Este producto no existe");
        }
	}

	@Override
	public producto getProducto(int idProducto) throws Exception {
		
		try {
            java.util.Optional<producto> producto = productRepository.findById(idProducto);
            if (producto.isPresent()) {
                return producto.get();
            } else {
                return null;
            }

        } catch (java.util.NoSuchElementException ex) {
            throw new Exception("Este producto no existe");
        }
	}

	@Override
	public void updateProducto(producto product) throws Exception {
		try {
            java.util.Optional<producto> producto = productRepository.findById(product.getIdProducto());
            if (producto.isPresent()) {
            	productRepository.updateProduct(product.getIdProducto(), product.getNombre(), product.getPrecio());
            }
        } catch (java.util.NoSuchElementException ex) {
            throw new Exception("Este producto no existe");
        }		
	}

	
}
