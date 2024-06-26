package com.github.leandrochp.solid.srp.application;

import com.github.leandrochp.solid.srp.domain.Capitulo;
import com.github.leandrochp.solid.srp.domain.Ebook;
import com.github.leandrochp.solid.srp.epub.GeradorEPUB;
import com.github.leandrochp.solid.srp.md.RenderizadorMDParaHTML;
import com.github.leandrochp.solid.srp.pdf.GeradorPDF;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        var renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        if ("pdf".equals(formato)) {
            var geradorPDF = new GeradorPDF();
            geradorPDF.gera(ebook);

        } else if ("epub".equals(formato)) {
            var geradorEPUB = new GeradorEPUB();
            geradorEPUB.gera(ebook);

        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
    }
}
