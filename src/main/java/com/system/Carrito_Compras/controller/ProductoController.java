package com.system.Carrito_Compras.controller;

import com.system.Carrito_Compras.entity.Producto;
import com.system.Carrito_Compras.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto r) {
        try {
            return new ResponseEntity<>(productoService.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> obtenerLista() {
        try {
            return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}