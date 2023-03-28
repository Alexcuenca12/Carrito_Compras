package com.system.Carrito_Compras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carrito")
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    private Date fecha_carrito;

    private String estado_carrito;

    private Double valor_total;

    private boolean enabled = true;

    @OneToMany(mappedBy = "carrito",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Detalle_Carrito> detalleCarrito = new ArrayList<>();

    @OneToOne(mappedBy = "carrito")
    private Persona persona;
}