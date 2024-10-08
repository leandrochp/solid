package com.github.leandrochp.solid.isp.domain;

import com.github.leandrochp.solid.isp.application.GeradorEbook;
import com.github.leandrochp.solid.isp.epub.GeradorEPUB;
import com.github.leandrochp.solid.isp.html.GeradorHTML;
import com.github.leandrochp.solid.isp.pdf.GeradorPDF;

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
