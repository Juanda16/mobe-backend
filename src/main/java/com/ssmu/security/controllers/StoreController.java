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

import com.ssmu.security.model.Store;
import com.ssmu.security.services.StoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api_v1/stores")
// @SecurityRequirement(name = "bearerAuth")
@Tag(name = "Category", description = "The User API. Contains all the operations that can be performed on a Store.")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Operation(summary = "Get all stores", description = "Get all stores")
    // @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Store>> listar() {
        System.out.println("listar todos>>>");

        try {
            return ResponseEntity.ok(storeService.getAllStores());
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Store buscar(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable Long id) {
        storeService.deleteStoreById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Integer id, @RequestBody Store store) {
        store.setId(id);
        storeService.updateStore(store);
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
