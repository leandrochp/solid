package com.github.leandrochp.solid.lsp.application;

import com.github.leandrochp.solid.lsp.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {

    Path getDiretorioDosMD();

    FormatoEbook getFormato();

    Path getArquivoDeSaida();
}
