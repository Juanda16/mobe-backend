package com.ssmu.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssmu.security.model.AppUser;
import com.ssmu.security.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api_v1/users")
// @SecurityRequirement(name = "bearerAuth")
@Tag(name = "User", description = "The User API. Contains all the operations that can be performed on a user.")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users", description = "Get all usersr")
    // @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(value = "/all")
    public ResponseEntity<List<AppUser>> listar() {
        System.out.println("listar todos>>>");

        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AppUser buscar(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Long id, @RequestBody AppUser user) {
        user.setId(id);
        userService.updateUser(user);
    }

    // @RequestMapping(value = "/add", method = RequestMethod.POST)
    // public AppUser crear(@RequestBody AppUser user) {
    // System.out.println("user: " + user.toString());

    // return userService.saveUser(user);

    // }

}
