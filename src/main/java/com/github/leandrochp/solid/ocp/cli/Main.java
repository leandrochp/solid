package com.github.leandrochp.solid.ocp.cli;

import com.github.leandrochp.solid.ocp.CotubaConfig;
import com.github.leandrochp.solid.ocp.application.Cotuba;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        boolean modoVerboso = false;

        try {
            var opcoesCLI = new LeitorOpcoesCLI(args);
            modoVerboso = opcoesCLI.isModoVerboso();

            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CotubaConfig.class);
            Cotuba cotuba = applicationContext.getBean(Cotuba.class);

            cotuba.executa(opcoesCLI);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (modoVerboso) {
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }

}
