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

import com.ssmu.security.model.Category;
import com.ssmu.security.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api_v1/categories")
// @SecurityRequirement(name = "bearerAuth")
@Tag(name = "Category", description = "The User API. Contains all the operations that can be performed on a category.")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Get all categories", description = "Get all categories")
    // @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> listar() {
        System.out.println("listar todos>>>");

        try {
            return ResponseEntity.ok(categoryService.getAllCategories());
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category buscar(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
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
