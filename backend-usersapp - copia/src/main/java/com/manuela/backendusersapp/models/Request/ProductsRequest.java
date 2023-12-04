package com.manuela.backendusersapp.models.Request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductsRequest {
    @NotBlank
    @Size(min = 5)
    @Column(unique = true)
    private String name;

    @NotBlank
    private String precio;

    @NotBlank
    private String descripcion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
