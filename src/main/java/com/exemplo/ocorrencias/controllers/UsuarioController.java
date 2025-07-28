
package com.exemplo.ocorrencias.controllers;

import com.exemplo.ocorrencias.domain.user.User;
import com.exemplo.ocorrencias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public User criarUsuario(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
