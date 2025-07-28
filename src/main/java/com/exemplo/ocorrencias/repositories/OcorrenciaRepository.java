
package com.exemplo.ocorrencias.repositories;

import com.exemplo.ocorrencias.domain.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
