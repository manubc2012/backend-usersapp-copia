package com.manuela.backendusersapp.repository;

import com.manuela.backendusersapp.models.entities.Productos;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepositoty extends CrudRepository<Productos, Long> {
}
