package com.github.leandrochp.solid.ocp.application;

import com.github.leandrochp.solid.ocp.domain.Ebook;
import com.github.leandrochp.solid.ocp.domain.FormatoEbook;

public interface GeradorEbook {
    void gera(Ebook ebook);

    boolean accept(FormatoEbook formato);
}
