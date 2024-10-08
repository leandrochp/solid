package com.github.leandrochp.solid.isp.application;

import com.github.leandrochp.solid.isp.domain.Ebook;
import com.github.leandrochp.solid.isp.domain.FormatoEbook;

public interface GeradorEbook {

    void gera(Ebook ebook);

    static GeradorEbook cria(FormatoEbook formato) {
        return formato.getGerador();
    }

}