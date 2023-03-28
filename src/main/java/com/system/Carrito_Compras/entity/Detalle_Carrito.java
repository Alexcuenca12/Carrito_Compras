package com.system.Carrito_Compras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_carrito")
public class Detalle_Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalleCarrito;

    private Double cantidad;

    private Double valor_total;

    private boolean enabled = true;

    @OneToMany(mappedBy = "detalleCarrito",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;
}
