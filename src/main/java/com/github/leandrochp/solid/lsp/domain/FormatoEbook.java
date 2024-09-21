package com.github.leandrochp.solid.lsp.domain;

import com.github.leandrochp.solid.lsp.application.GeradorEbook;
import com.github.leandrochp.solid.lsp.epub.GeradorEPUB;
import com.github.leandrochp.solid.lsp.html.GeradorHTML;
import com.github.leandrochp.solid.lsp.pdf.GeradorPDF;

public enum FormatoEbook {

    PDF(new GeradorPDF()),
    EPUB(new GeradorEPUB()),
    HTML(new GeradorHTML());

    private GeradorEbook gerador;

    FormatoEbook(GeradorEbook gerador) {
        this.gerador = gerador;
    }

    public GeradorEbook getGerador() {
        return gerador;
    }
}
