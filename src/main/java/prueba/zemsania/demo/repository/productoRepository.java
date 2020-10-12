package prueba.zemsania.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import prueba.zemsania.demo.model.producto;

public interface productoRepository extends JpaRepository<producto,Integer>{
	
	@Transactional
    @Modifying
	@Query("update producto p set p.nombre= ?2 , p.precio = ?3 where p.id_producto = ?1")
	void updateProduct(int idProducto,String nombre,Long precio);
}
