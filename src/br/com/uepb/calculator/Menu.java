package br.com.uepb.calculator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static void start() throws InterruptedException{

        System.out.println("""
                ---------------------------------------------
                Bem vindo à calculadora científica eletrônica
                ---------------------------------------------
                """);
        TimeUnit.SECONDS.sleep(3);
        mOptions();
    }

    private static void mOptions() {
        System.out.println("""
                
                Estas são as opções da calculadora científica:
                (+) Adição                (-) Subtração
                (*) Multiplicação)        (/) Divisão
                (exp) Exponencial         (^2) Ao quadrado
                (Ln) Logaritimo Natural   (log) Logaritmo
                (sroot) Raiz Quadrada     (cos) Cosseno de x
                (sen) Seno de x           (tg) Tangente de x
                (pi) Número pi
                               -Você pode voltar aqui digitando help.
                """);

    }

}
