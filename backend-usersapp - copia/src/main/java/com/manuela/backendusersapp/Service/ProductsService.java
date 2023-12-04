package com.manuela.backendusersapp.Service;

import com.manuela.backendusersapp.models.Request.ProductsRequest;
import com.manuela.backendusersapp.models.Request.UserRequest;
import com.manuela.backendusersapp.models.dto.ProductDto;
import com.manuela.backendusersapp.models.entities.Productos;
import com.manuela.backendusersapp.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductDto> findAll();

    Optional<ProductDto> findById(Long id);

    ProductDto save(Productos productos);
    Optional<ProductDto> update(ProductsRequest productos, Long id);

    void remove(Long id);
}
