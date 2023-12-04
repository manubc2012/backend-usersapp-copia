package com.manuela.backendusersapp.models.dto.mapper;

import com.manuela.backendusersapp.models.dto.ProductDto;
import com.manuela.backendusersapp.models.dto.UsersDto;
import com.manuela.backendusersapp.models.entities.Productos;
import com.manuela.backendusersapp.models.entities.User;

public class DtoProductsMapper {
    private Productos productos;

    private DtoProductsMapper() {

    }

    public static DtoProductsMapper builder(){
        return new DtoProductsMapper();
    }

    public DtoProductsMapper setProduct(Productos productos) {
        this.productos = productos;
        return this;
    }

    public ProductDto build(){
        if (productos== null){
            throw new RuntimeException("Debe pasar el entity");
        }
        return new ProductDto (this.productos.getId(), productos.getName(), productos.getPrecio(), productos.getDescripcion(), productos.getCategoria());

    }
}
