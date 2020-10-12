package prueba.zemsania.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prueba.zemsania.demo.model.cliente;

public interface clienteRepository extends JpaRepository<cliente,Integer>{
	
	@Query(value="select c.id_cliente, c.nombre, c.apellido, c.dni, c.telefono, c.email, c.password from cliente c",nativeQuery = true)
	List<cliente> allClients();
	
	@Query(value="select c.id_cliente, c.nombre, c.apellido, c.dni, c.telefono, c.email, c.password from cliente c where c.id_cliente = ?1 and c.password = ?2",nativeQuery = true)
	cliente loginClient(int idCliente,String password);
	
}
