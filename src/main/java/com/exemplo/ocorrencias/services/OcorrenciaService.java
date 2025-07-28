
package com.exemplo.ocorrencias.services;

import com.exemplo.ocorrencias.domain.ocorrencia.Ocorrencia;
import com.exemplo.ocorrencias.repositories.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public List<Ocorrencia> listar() {
        return repository.findAll();
    }

    public Ocorrencia salvar(Ocorrencia o) {
        return repository.save(o);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
