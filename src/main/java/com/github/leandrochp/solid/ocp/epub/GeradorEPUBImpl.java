package com.github.leandrochp.solid.ocp.epub;

import com.github.leandrochp.solid.ocp.application.GeradorEbook;
import com.github.leandrochp.solid.ocp.domain.Capitulo;
import com.github.leandrochp.solid.ocp.domain.Ebook;
import com.github.leandrochp.solid.ocp.domain.FormatoEbook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class GeradorEPUBImpl implements GeradorEbook {

    @Override
    public void gera(Ebook ebook) {
        Path arquivoDeSaida = ebook.getArquivoDeSaida();

        var epub = new Book();

        for (Capitulo capitulo : ebook.getCapitulos()) {
            String html = capitulo.getConteudoHTML();
            String tituloDoCapitulo = capitulo.getTitulo();

            epub.addSection(tituloDoCapitulo, new Resource(html.getBytes(), MediatypeService.XHTML));

            var epubWriter = new EpubWriter();
            try {
                epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
            } catch (IOException ex) {
                throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
            }
        }
    }

    @Override
    public boolean accept(FormatoEbook formato) {
        return FormatoEbook.EPUB.equals(formato);
    }
}
