package com.system.Carrito_Compras.controller;
import com.system.Carrito_Compras.entity.Persona;
import com.system.Carrito_Compras.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        try {
            return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarP")
    public ResponseEntity<List<Persona>> obtenerPacientes() {
        try {
            return new ResponseEntity<>(personaService.listar(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarcedul/{cedula}")
    public Persona obtenerUsuario(@PathVariable("cedula") String cedula) {
        return personaService.search(cedula);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona p) {
        try {
            return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Persona p) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                persona.setEnabled(persona.isEnabled());
                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarUsuario(@PathVariable Long id, @RequestBody Persona p) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                persona.setCedula(p.getCedula());
                persona.setNombre(p.getNombre());
                persona.setApellido(p.getApellido());
                persona.setEmail(p.getEmail());
                persona.setSexo(p.getSexo());
                persona.setTelefono(p.getTelefono());
                persona.setCelular(p.getCelular());
                persona.setCodigo_postal(p.getCodigo_postal());
                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
