package com.github.leandrochp.solid.isp.epub;

import com.github.leandrochp.solid.isp.application.GeradorEbook;
import com.github.leandrochp.solid.isp.domain.Capitulo;
import com.github.leandrochp.solid.isp.domain.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorEPUB implements GeradorEbook {

    @Override
    public void gera(Ebook ebook) {
        Path arquivoDeSaida = ebook.getArquivoDeSaida();

        var epub = new Book();
        for (Capitulo capitulo : ebook.getCapitulos()) {

            String html = capitulo.getConteudoHTML();

            String tituloDoCapitulo = capitulo.getTitulo();
            epub.addSection(tituloDoCapitulo,
                    new Resource(html.getBytes(), MediatypeService.XHTML));
        }

        var epubWriter = new EpubWriter();
        try {
            epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
        } catch (IOException ex) {
            throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
        }
    }
}
