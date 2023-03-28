package com.system.Carrito_Compras.controller;

import com.system.Carrito_Compras.entity.Detalle_Carrito;
import com.system.Carrito_Compras.service.IDetalleFacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/detallefactura")
public class DetalleFacController {

    @Autowired
    IDetalleFacService DetalleService;

    @PostMapping("/crear")
    public ResponseEntity<Detalle_Carrito> crear(@RequestBody Detalle_Carrito r) {
        try {
            return new ResponseEntity<>(DetalleService.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<Detalle_Carrito>> obtenerLista() {
        try {
            return new ResponseEntity<>(DetalleService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Detalle_Carrito> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(DetalleService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
