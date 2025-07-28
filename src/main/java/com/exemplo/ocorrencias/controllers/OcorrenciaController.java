
package com.exemplo.ocorrencias.controllers;

import com.exemplo.ocorrencias.domain.ocorrencia.Ocorrencia;
import com.exemplo.ocorrencias.services.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @GetMapping
    public List<Ocorrencia> listar() {
        return service.listar();
    }

    @PostMapping
    public Ocorrencia salvar(@RequestBody Ocorrencia o) {
        return service.salvar(o);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
