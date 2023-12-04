package com.manuela.backendusersapp.Service;

import com.manuela.backendusersapp.models.Request.ProductsRequest;
import com.manuela.backendusersapp.models.dto.ProductDto;
import com.manuela.backendusersapp.models.dto.mapper.DtoProductsMapper;
import com.manuela.backendusersapp.models.entities.Productos;
import com.manuela.backendusersapp.models.entities.User;
import com.manuela.backendusersapp.repository.ProductsRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    private ProductsRepositoty repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Productos> productos = (List<Productos>) repository.findAll();
        return productos.stream().map(p -> DtoProductsMapper
                        .builder().setProduct(p).build())
                        .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> findById(Long id) {
        return repository.findById(id).map(p -> DtoProductsMapper
                .builder()
                .setProduct(p)
                .build());
    }

    @Override
    @Transactional
    public ProductDto save(Productos productos) {
        return DtoProductsMapper.builder()
                .setProduct(repository.save(productos)).build();
    }

    @Override
    @Transactional
    public Optional<ProductDto> update(ProductsRequest productos, Long id) {
        Optional<Productos> o = repository.findById(id);
        Productos prodOptional = null;
        if (o.isPresent()) {
            Productos prodDb = o.orElseThrow();
            prodDb.setName(productos.getName());
            prodDb.setPrecio(productos.getPrecio());
            prodDb.setDescripcion(productos.getDescripcion());
            prodOptional = repository.save(prodDb);
        }
        return Optional.ofNullable(DtoProductsMapper.builder().setProduct(prodOptional).build());    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
