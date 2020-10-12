package prueba.zemsania.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prueba.zemsania.demo.model.producto;
import prueba.zemsania.demo.service.productoService;

@RestController
@RequestMapping(value="/product")
public class productoController {
	
	@Autowired
	productoService productService;
	
	@RequestMapping(method=RequestMethod.GET,path="/{id}")
	public ResponseEntity<producto> getProducto(@PathVariable("id") int idProducto){
		try{
			return ResponseEntity.ok(productService.getProducto(idProducto));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/allProductos")
	public ResponseEntity<List<producto>> getAllProductos(){
		try{
			return ResponseEntity.ok(productService.getAllProductos());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/saveProduct")
	public void saveProducto(@RequestBody producto product){
		try{
			System.out.println("guarda");
			productService.saveProducto(product);
		}catch(Exception e){
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/updateProduct")
	public void updateProducto(@RequestBody producto product){
		try{
			productService.updateProducto(product);
		}catch(Exception e){
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	
}
