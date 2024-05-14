package com.ssmu.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ssmu.security.model.Product;
import com.ssmu.security.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api_v1/products")
// @SecurityRequirement(name = "bearerAuth")
@Tag(name = "Category", description = "The User API. Contains all the operations that can be performed on a Product.")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all products", description = "Get all products")
    // @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> listar() {
        System.out.println("listar todos>>>");

        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product buscar(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
    }

    /*
     * @RequestMapping(value = "/add", method = RequestMethod.POST)
     * public Category crear(@RequestBody Category category) {
     * System.out.println("category: " + category.toString());
     * 
     * return categoryService.saveCategory(category);
     * 
     * }
     */

}
