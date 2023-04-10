package com.system.Carrito_Compras.controller;
import com.system.Carrito_Compras.entity.Rol;
import com.system.Carrito_Compras.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/rol")
public class RolController {

	@Autowired
	IRolService rolService;

	@PostMapping("/crear")
	public ResponseEntity<Rol> crear(@RequestBody Rol r) {
		try {
			return new ResponseEntity<>(rolService.save(r), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> obtenerLista() {
		try {
			return new ResponseEntity<>(rolService.listar(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Rol> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(rolService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Rol r) {
		Rol rol = rolService.findById(id);
		if (rol == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				rol.setEnabled(false);
				return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Rol> actualizarCategoria(@PathVariable Long id,@RequestBody Rol r) {
		Rol rol = rolService.findById(id);
		if (rol == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				rol.setRolNombre(rol.getRolNombre());
				rol.setDescripcion(rol.getDescripcion());
				return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}
}
