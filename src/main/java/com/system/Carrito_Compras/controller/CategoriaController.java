package com.system.Carrito_Compras.controller;

import com.system.Carrito_Compras.entity.Categoria;
import com.system.Carrito_Compras.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;

    @PostMapping("/crear")
    public ResponseEntity<Categoria> crear(@RequestBody Categoria r) {
        try {
            return new ResponseEntity<>(categoriaService.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> obtenerLista() {
        try {
            return new ResponseEntity<>(categoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(categoriaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
