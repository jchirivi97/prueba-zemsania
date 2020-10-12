package prueba.zemsania.demo.service;

import java.util.List;

import prueba.zemsania.demo.model.*;

public interface ventaService {

	List<venta> getAllClient(int idclient);
	
	venta saveVenta(venta venta);
	
}
