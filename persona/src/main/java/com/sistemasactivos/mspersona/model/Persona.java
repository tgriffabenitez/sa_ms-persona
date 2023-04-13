package com.sistemasactivos.mspersona.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona extends Base{

    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Column(name = "email")
    @Email(message = "El email no es válido")
    private String email;

    @Column(name = "telefono")
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @Column(name = "direccion")
    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @Column(name = "ciudad")
    @NotBlank(message = "La ciudad no puede estar vacía")
    private String ciudad;

    @Column(name = "pais")
    @NotBlank(message = "El país no puede estar vacío")
    private String pais;

    @Column(name = "codigo_postal")
    @NotBlank(message = "El código postal no puede estar vacío")
    private String codigoPostal;

    @Column(name = "cuit")
    @NotBlank(message = "El cuit no puede estar vacío")
    private String cuit;
}
