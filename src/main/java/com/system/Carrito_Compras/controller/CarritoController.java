package com.system.Carrito_Compras.controller;

import com.system.Carrito_Compras.entity.Carrito;
import com.system.Carrito_Compras.entity.Categoria;
import com.system.Carrito_Compras.service.ICarritoService;
import com.system.Carrito_Compras.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    ICarritoService CarritoService;

    @PostMapping("/crear")
    public ResponseEntity<Carrito> crear(@RequestBody Carrito r) {
        try {
            return new ResponseEntity<>(CarritoService.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Carrito>> obtenerLista() {
        try {
            return new ResponseEntity<>(CarritoService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Carrito> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(CarritoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
