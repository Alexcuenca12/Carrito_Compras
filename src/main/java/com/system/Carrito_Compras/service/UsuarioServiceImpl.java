package com.system.Carrito_Compras.service;


import com.system.Carrito_Compras.entity.Usuario;
import com.system.Carrito_Compras.repository.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements IUsuarioService {

	@Autowired
	private IUsuarioDao UsuarioDao;

	@Override
	@Transactional(readOnly = true)
	public Usuario search(String username) {
		return UsuarioDao.findByUsername(username);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		UsuarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) UsuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarUsuario(String username) {
		return ((IUsuarioService) UsuarioDao).buscarUsuario(username);
	}

	@Override
	public CrudRepository<Usuario, Long> getDao() {
		return UsuarioDao;
	}

	@Override
	public List<Usuario> listarUsuario() {
		return UsuarioDao.listarUsuario();
	}

}
