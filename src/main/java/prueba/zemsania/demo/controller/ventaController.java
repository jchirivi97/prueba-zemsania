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

import prueba.zemsania.demo.model.venta;
import prueba.zemsania.demo.service.ventaService;

@RestController
@RequestMapping(value="/venta")
public class ventaController {

	@Autowired
	ventaService ventaServ;
	
	@RequestMapping(method=RequestMethod.GET,path="/{id}")
	public ResponseEntity<List<venta>> getAllVenta(@PathVariable("id") int idclient){
		try{
			return ResponseEntity.ok(ventaServ.getAllClient(idclient));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/saveVenta")
	public ResponseEntity<venta> saveVenta(@RequestBody venta venta){
		try{
			return ResponseEntity.ok(ventaServ.saveVenta(venta));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
}
