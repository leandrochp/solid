package com.github.leandrochp.solid.ocp.application;

import com.github.leandrochp.solid.ocp.domain.Capitulo;
import com.github.leandrochp.solid.ocp.domain.Ebook;
import com.github.leandrochp.solid.ocp.domain.FormatoEbook;
import com.github.leandrochp.solid.ocp.md.RenderizadorMDParaHTML;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class Cotuba {

    private final List<GeradorEbook> geradoresEBook;
    private final RenderizadorMDParaHTML renderizador;

    public Cotuba(List<GeradorEbook> geradoresEBook, RenderizadorMDParaHTML renderizador) {
        this.geradoresEBook = geradoresEBook;
        this.renderizador = renderizador;
    }

    public void executa(ParametrosCotuba parametros) {
        FormatoEbook formato = parametros.getFormato();
        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();

        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorEbook geradorEbook = geradoresEBook.stream()
                .filter(gerador -> gerador.accept(formato))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Formato do ebook inválido: " + formato));

        geradorEbook.gera(ebook);

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
    }
}
