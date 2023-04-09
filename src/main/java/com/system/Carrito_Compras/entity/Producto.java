package com.system.Carrito_Compras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nom_Producto;

    private int stock;

    private String descripcion;

    private Double valor_unitario;

    @Lob
    @Column(name = "foto", columnDefinition="longblob")
    private byte[] foto;

    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Detalle_Carrito> detalleCarrito = new ArrayList<>();
}
