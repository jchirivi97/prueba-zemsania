package prueba.zemsania.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.zemsania.demo.model.cliente;
import prueba.zemsania.demo.repository.clienteRepository;
import prueba.zemsania.demo.service.clienteService;

@Service
public class clienteServiceImp implements clienteService{
	
	@Autowired
	clienteRepository clientRepository;

	@Override
	public void saveClient(cliente cliente) {
		clientRepository.save(cliente);
	}

	@Override
	public List<cliente> allClients() {
		return clientRepository.allClients();
	}

	@Override
	public cliente loginClient(int idCliente, String password) {
		return clientRepository.loginClient(idCliente, password);
	}

	@Override
	public cliente getClient(int idCliente) {
		return clientRepository.findById(idCliente).get();
	}
	
	

}
