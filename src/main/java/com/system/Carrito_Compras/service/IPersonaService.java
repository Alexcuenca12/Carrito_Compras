package com.system.Carrito_Compras.service;


import com.system.Carrito_Compras.entity.Persona;

import java.util.List;

public interface IPersonaService extends IGenericService<Persona, Long> {

	public Persona search(String cedula);

	public List<Persona> listar();

	
}
