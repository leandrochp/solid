package com.github.leandrochp.solid.lsp.plugin;

import com.github.leandrochp.solid.lsp.domain.Capitulo;
import com.github.leandrochp.solid.lsp.domain.Ebook;

import java.util.ServiceLoader;

public interface Plugin {

    String aposRenderizacao(String html);

    void aposGeracao(Ebook ebook);

    static void renderizou(Capitulo capitulo) {
        ServiceLoader.load(Plugin.class)
                .forEach(plugin -> {
                    String html = capitulo.getConteudoHTML();
                    String htmlModificado = plugin.aposRenderizacao(html);
                    capitulo.setConteudoHTML(htmlModificado);
                });
    }

    static void gerou(Ebook ebook) {
        ServiceLoader.load(Plugin.class)
                .forEach(plugin -> plugin.aposGeracao(ebook));
    }

}
