package prueba.zemsania.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prueba.zemsania.demo.model.detalleVenta;
import prueba.zemsania.demo.service.detalleVentaService;

@RestController
@RequestMapping(value="/detalle")
public class detalleVentaController {

	@Autowired
	detalleVentaService detalleVentaServ;
	
	@RequestMapping(method=RequestMethod.GET,path="/{idventa}")
	public ResponseEntity<detalleVenta> getDetalleVenta(@PathVariable("idventa") int idventa){
		try{
			return ResponseEntity.ok(detalleVentaServ.getDetalle(idventa));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/saveDetalle")
	public ResponseEntity<?> saveProducto(@RequestBody detalleVenta detalle){
		try{
			detalleVentaServ.saveDetalle(detalle);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
