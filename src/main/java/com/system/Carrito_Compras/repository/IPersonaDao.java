package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	public Persona findByCedula(String cedula);

	Boolean existsByCedula(String cedula);

	public Persona findByEmail(String email);

	Boolean existsByEmail(String email);
}
