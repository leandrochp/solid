package com.github.leandrochp.solid.lsp.application;

import com.github.leandrochp.solid.lsp.domain.Capitulo;
import com.github.leandrochp.solid.lsp.domain.Ebook;
import com.github.leandrochp.solid.lsp.domain.FormatoEbook;
import com.github.leandrochp.solid.lsp.md.RenderizadorMDParaHTML;
import com.github.leandrochp.solid.lsp.plugin.Plugin;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(ParametrosCotuba parametros) {

        FormatoEbook formato = parametros.getFormato();
        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();

        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);

        GeradorEbook gerador = GeradorEbook.cria(formato);
        gerador.gera(ebook);

        Plugin.gerou(ebook);
    }

}
