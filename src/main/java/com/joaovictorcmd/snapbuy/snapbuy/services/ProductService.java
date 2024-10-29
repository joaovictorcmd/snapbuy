package com.joaovictorcmd.snapbuy.snapbuy.services;

import com.joaovictorcmd.snapbuy.snapbuy.dto.ProductDTO;
import com.joaovictorcmd.snapbuy.snapbuy.entities.Product;
import com.joaovictorcmd.snapbuy.snapbuy.repositories.ProductRepository;
import com.joaovictorcmd.snapbuy.snapbuy.services.exceptions.DatabaseException;
import com.joaovictorcmd.snapbuy.snapbuy.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 24
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = new Product();
        convertDtoToEntity(productDTO, product);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product product = productRepository.getReferenceById(id);
            convertDtoToEntity(productDTO, product);
            product = productRepository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
            try {
                productRepository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException("Recurso não encontrado");
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException("Falha de integridade referencial");
            }

    }

    private void convertDtoToEntity(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }
}
