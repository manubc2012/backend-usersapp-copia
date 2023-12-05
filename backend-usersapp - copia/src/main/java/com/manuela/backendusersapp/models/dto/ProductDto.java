package com.manuela.backendusersapp.models.dto;

public class ProductDto {

    private Long id;
    private String name;
    private String precio;
    private String descripcion;

    private String categoria;



    public ProductDto(Long id, String name, String precio, String descripcion, String categoria) {
        this.id = id;
        this.name = name;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
