package com.github.leandrochp.solid.dip.application;

import com.github.leandrochp.solid.dip.domain.Capitulo;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorMDParaHTML {
    List<Capitulo> renderiza(Path diretorioDosMD);
}
