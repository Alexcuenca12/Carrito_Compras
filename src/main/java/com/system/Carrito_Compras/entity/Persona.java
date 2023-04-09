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
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;


    @Column(name = "cedula", nullable = false)
    private String cedula;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 45, nullable = false)
    private String apellido;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "sexo", length = 45, nullable = false)
    private String sexo;

    @Column(name = "telefono", length = 50, nullable = false)
    private String telefono;

    @Column(name = "celular", length = 45, nullable = false)
    private String celular;

    @Column(name = "codigo_postal", length = 50, nullable = false)
    private String codigo_postal;

    private boolean enabled = true;

    @OneToMany(mappedBy = "persona_carrito",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Carrito> carritos = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "persona")
    private Usuario usuario;


}
