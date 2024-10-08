package com.github.leandrochp.solid.isp.domain;

import com.github.leandrochp.solid.isp.plugin.CapituloSoParaLeitura;

public class Capitulo implements CapituloSoParaLeitura {

    private String titulo;
    private String conteudoHTML;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }
}
