package com.github.leandrochp.solid.dip.application;

import com.github.leandrochp.solid.dip.domain.Ebook;

public interface GeradorEPUB {
    void gera(Ebook ebook);
}
