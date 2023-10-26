package br.com.uepb;

import br.com.uepb.calculator.Functions;
import br.com.uepb.calculator.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException, Exception {
        String expressao;
        do {
            Menu.start();
            System.out.println("Escreva sua equação.");
            expressao = leitor.next();
            Functions.execute(expressao);
        }while(true);


    }
}