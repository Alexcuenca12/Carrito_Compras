package com.system.Carrito_Compras.service;

import com.system.Carrito_Compras.entity.Usuario;

import java.util.List;

public interface IUsuarioService extends IGenericService<Usuario, Long> {

	public Usuario save(Usuario usuario);

	public Usuario search(String username);

	public void delete(Long id);

	public List<Usuario> getUsuarios();

	public List<Usuario> buscarUsuario(String cedula);

	public List<Usuario> listarUsuario();

}
