package com.github.leandrochp.solid.ocp.domain;

import com.github.leandrochp.solid.ocp.application.GeradorEbook;
import com.github.leandrochp.solid.ocp.epub.GeradorEPUBImpl;
import com.github.leandrochp.solid.ocp.html.GeradorHTMLImpl;
import com.github.leandrochp.solid.ocp.pdf.GeradorPDFImpl;

public enum FormatoEbook {
    PDF(new GeradorPDFImpl()),
    EPUB(new GeradorEPUBImpl()),
    HTML(new GeradorHTMLImpl());

    private GeradorEbook geradorEbook;

    FormatoEbook(GeradorEbook gerador) {
        this.geradorEbook = gerador;
    }

    public GeradorEbook getGeradorEbook() {
        return geradorEbook;
    }
}
