package com.github.leandrochp.solid.srp.cli;

import com.github.leandrochp.solid.srp.application.Cotuba;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path diretorioDosMD;
        String formato;
        Path arquivoDeSaida;
        boolean modoVerboso = false;

        try {
            var opcoesCLI = new LeitorOpcoesCLI(args);
            diretorioDosMD = opcoesCLI.getDiretorioDosMD();
            formato = opcoesCLI.getFormato();
            arquivoDeSaida = opcoesCLI.getArquivoDeSaida();

            modoVerboso = opcoesCLI.isModoVerboso();

            var cotuba = new Cotuba();
            cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (modoVerboso) {
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }

}
