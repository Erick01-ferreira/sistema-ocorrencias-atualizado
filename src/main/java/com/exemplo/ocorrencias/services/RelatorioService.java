
package com.exemplo.ocorrencias.services;

import com.exemplo.ocorrencias.domain.relatorio.Relatorio;
import com.exemplo.ocorrencias.repositories.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public List<Relatorio> listar() {
        return repository.findAll();
    }

    public Relatorio salvar(Relatorio r) {
        return repository.save(r);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
