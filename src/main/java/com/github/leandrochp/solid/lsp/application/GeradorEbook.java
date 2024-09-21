package com.github.leandrochp.solid.lsp.application;

import com.github.leandrochp.solid.lsp.domain.Ebook;
import com.github.leandrochp.solid.lsp.domain.FormatoEbook;

public interface GeradorEbook {

    void gera(Ebook ebook);

    static GeradorEbook cria(FormatoEbook formato) {
        return formato.getGerador();
    }

}
