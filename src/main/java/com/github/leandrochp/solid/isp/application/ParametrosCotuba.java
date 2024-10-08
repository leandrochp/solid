package com.github.leandrochp.solid.isp.application;

import com.github.leandrochp.solid.isp.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {

    Path getDiretorioDosMD();

    FormatoEbook getFormato();

    Path getArquivoDeSaida();
}
