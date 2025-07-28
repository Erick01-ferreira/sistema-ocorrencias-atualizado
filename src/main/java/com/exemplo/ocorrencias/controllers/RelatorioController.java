
package com.exemplo.ocorrencias.controllers;

import com.exemplo.ocorrencias.domain.relatorio.Relatorio;
import com.exemplo.ocorrencias.services.RelatorioService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping
    public List<Relatorio> listar() {
        return service.listar();
    }

    @PostMapping
    public Relatorio salvar(@RequestBody Relatorio r) {
        return service.salvar(r);
    }

    @PostMapping("/pdf/{id}")
    public String salvarPdf(@PathVariable Long id) {
        Relatorio relatorio = service.listar().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElse(null);
        if (relatorio == null) return "Relatório não encontrado";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("relatorio_" + id + ".pdf"));
            document.open();
            document.add(new Paragraph("Título: " + relatorio.getTitulo()));
            document.add(new Paragraph("Conteúdo: " + relatorio.getConteudo()));
            document.close();
            return "PDF gerado com sucesso";
        } catch (Exception e) {
            return "Erro ao gerar PDF: " + e.getMessage();
        }
    }
}
