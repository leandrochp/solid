package com.github.leandrochp.solid.ocp.application;

import com.github.leandrochp.solid.ocp.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {
    Path getDiretorioDosMD();

    FormatoEbook getFormato();

    Path getArquivoDeSaida();
}
