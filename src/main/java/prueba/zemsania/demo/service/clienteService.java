package prueba.zemsania.demo.service;

import java.util.List;

import prueba.zemsania.demo.model.cliente;

public interface clienteService {
	
	void saveClient (cliente cliente);
	
	List<cliente> allClients();
	
	cliente loginClient(int idCliente,String password);
	
	cliente getClient(int idCliente);
}
