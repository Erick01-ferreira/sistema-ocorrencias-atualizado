package com.exemplo.ocorrencias.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String menu() {
        return "Usuários: /usuarios\nRelatórios: /relatorios\nOcorrências: /ocorrencias";
    }
}