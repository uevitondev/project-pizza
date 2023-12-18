package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.entities.Category;
import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.exceptions.DatabaseException;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.CategoryRepository;
import com.uevitondev.mspizza.repositories.PizzeriaRepository;
import com.uevitondev.mspizza.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PizzeriaRepository pizzeriaRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, PizzeriaRepository pizzeriaRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.pizzeriaRepository = pizzeriaRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllProducts(Pageable pageable) {
        Page<ProductDTO> map = productRepository.findAllProductsPaged(pageable).map(product -> new ProductDTO(product));
        return map;
    }


    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProductsByPizzeriaId(Long id, Pageable pageable) {
        Page<ProductDTO> map = productRepository.findAllProductsPagedByPizzeriaId(id, pageable).map(product -> new ProductDTO(product));
        return map;
    }


    /*@Transactional(readOnly = true)
    public List<ProductDTO> getAllProductsByPizzeriaId(Long id) {
        return productRepository.findProductsByPizzeriaId(id).stream().map(ProductDTO::new).toList();
    }*/

    @Transactional(readOnly = true)
    public ProductDTO findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found, for id: " + id));
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO insertNewProduct(ProductDTO dto) {
        Product product = productRepository.save(convertProductDtoToProduct(dto));
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO updateProductById(Long id, ProductDTO dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("category not found, for id: " + dto.getCategoryId()));

        Pizzeria pizzeria = pizzeriaRepository.findById(dto.getPizzeriaId())
                .orElseThrow(() -> new ResourceNotFoundException("pizzeria not found, for id: " + dto.getPizzeriaId()));

        try {
            Product product = productRepository.getReferenceById(id);
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setCategory(category);
            product.setPizzeria(pizzeria);

            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("product not found, for id: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("product not found, for id: " + id);
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation");
        }
    }

    public Product convertProductDtoToProduct(ProductDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("category not found, for id: " + dto.getCategoryId()));

        Pizzeria pizzeria = pizzeriaRepository.findById(dto.getPizzeriaId())
                .orElseThrow(() -> new ResourceNotFoundException("pizzeria not found, for id: " + dto.getPizzeriaId()));

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        product.setPizzeria(pizzeria);

        return product;
    }
}