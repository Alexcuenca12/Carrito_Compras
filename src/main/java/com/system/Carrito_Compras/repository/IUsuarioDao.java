package com.system.Carrito_Compras.repository;

import com.system.Carrito_Compras.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

	Boolean existsByUsername(String username);

	// Metodos Query
	@Query(value = "SELECT * FROM usuario WHERE username = ?", nativeQuery = true)
	List<Usuario> buscarUsername(String username);

	public boolean existsByPassword(String password);

	@Query(value = "Select * from usuario u join persona p on u.id_persona = p.id_persona", nativeQuery = true)
	List<Usuario>listarUsuario();

}
