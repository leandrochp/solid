package com.github.leandrochp.solid.isp.plugin;

import com.github.leandrochp.solid.isp.domain.Capitulo;

import java.util.ServiceLoader;

public interface AoRenderizarHTML {

    String aposRenderizacao(String html);

    static void renderizou(Capitulo capitulo) {
        ServiceLoader.load(AoRenderizarHTML.class)
                .forEach(plugin -> {
                    String html = capitulo.getConteudoHTML();
                    String htmlModificado = plugin.aposRenderizacao(html);
                    capitulo.setConteudoHTML(htmlModificado);
                });
    }
}
