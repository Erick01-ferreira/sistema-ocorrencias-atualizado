
package com.exemplo.ocorrencias.repositories;

import com.exemplo.ocorrencias.domain.relatorio.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
}
