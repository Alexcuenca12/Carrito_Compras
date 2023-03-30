package com.system.Carrito_Compras.controller;
import com.system.Carrito_Compras.entity.Carrito;
import com.system.Carrito_Compras.service.ICarritoService;
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


    @PutMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Carrito c) {
        Carrito carrito = CarritoService.findById(id);
        if (carrito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                carrito.setEnabled(c.isEnabled());
                return new ResponseEntity<>(CarritoService.save(carrito), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/actualizar/{id}")

    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id,@RequestBody Carrito c) {
        Carrito carrito = CarritoService.findById(id);
        if (carrito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                carrito.setFecha_carrito(c.getFecha_carrito());
                carrito.setEstado_carrito(c.getEstado_carrito());
                carrito.setValor_total(c.getValor_total());
                return new ResponseEntity<>(CarritoService.save(carrito), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
