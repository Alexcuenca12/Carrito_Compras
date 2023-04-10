package com.system.Carrito_Compras.service;


import com.system.Carrito_Compras.entity.Rol;
import com.system.Carrito_Compras.repository.IRolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements IRolService {

	@Autowired
	IRolDao rolRepository;

	@Override
	public CrudRepository<Rol, Long> getDao() {
		return rolRepository;
	}

	@Override
	public List<Rol> listar() {
		return rolRepository.listarRol();
	}
}
