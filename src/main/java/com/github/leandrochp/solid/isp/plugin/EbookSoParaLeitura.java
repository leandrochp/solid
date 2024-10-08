package com.github.leandrochp.solid.isp.plugin;

import com.github.leandrochp.solid.isp.domain.FormatoEbook;

import java.nio.file.Path;
import java.util.List;

public interface EbookSoParaLeitura {

    FormatoEbook getFormato();

    Path getArquivoDeSaida();

    List<? extends CapituloSoParaLeitura> getCapitulos();
}
