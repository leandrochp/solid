package com.github.leandrochp.solid.isp.application;

import com.github.leandrochp.solid.isp.domain.Capitulo;
import com.github.leandrochp.solid.isp.domain.Ebook;
import com.github.leandrochp.solid.isp.domain.FormatoEbook;
import com.github.leandrochp.solid.isp.md.RenderizadorMDParaHTML;
import com.github.leandrochp.solid.isp.plugin.AoFinalizarGeracao;

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

        AoFinalizarGeracao.gerou(ebook);
    }
}
