package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	public Persona findByCedula(String cedula);

	Boolean existsByCedula(String cedula);

	public Persona findByEmail(String email);

	Boolean existsByEmail(String email);

	@Query(value = "SELECT * from persona where enabled =1",nativeQuery = true)
	List<Persona> listarPersonas();


}
