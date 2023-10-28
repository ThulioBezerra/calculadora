package br.com.uepb.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.*;
public class Functions {
    public static float execute(String equacao) throws Exception{

        String token;

        float resultado;

        char[] caracteres = equacao.toCharArray();

        Stack <String> operadores = new Stack();

        Stack <Float> numeros = new Stack();

        ArrayList <String> tokens = new ArrayList<>();

        if (equacao.contains("(")){
            if(verifica_parenteses(caracteres));
            else throw new Exception("Parênteses mal posicionados.");
        }

        Pattern pattern = Pattern.compile("[-+*/()]|\\d*\\.?\\d+");

        Matcher matcher = pattern.matcher(equacao);

        while(matcher.find()){
            token = matcher.group();
            tokens.add(token);
            if (token.matches("[-+*/]")) {
                while (!operadores.isEmpty() && hasHigherPrecedence(token, operadores.peek())) {
                    calculateAndPush(numeros, operadores.pop());
                }
                operadores.add(token);
            } else if (token.equals("(")){
                operadores.add(token);
            } else if (token.equals(")")) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    calculateAndPush(numeros, operadores.pop());
                }
                operadores.pop();
            } else if (token.matches("[-+]?\\d*\\.?\\d+")) {
                numeros.add(Float.parseFloat(token));
            }
        }

        while (!operadores.isEmpty()) {
            calculateAndPush(numeros, operadores.pop());
        }

        resultado = numeros.pop();
        return resultado;
    }

    public static boolean  verifica_parenteses(char[] expressao){
        int verificador_parenteses=0;
        for (char x:expressao) {
            if (x=='(') verificador_parenteses++;
            else if (x==')') verificador_parenteses--;
            if(verificador_parenteses<0) return false;
        }
        return verificador_parenteses == 0;
    }
    private static boolean hasHigherPrecedence(String op1, String op2) {
        int p1 = getPrecedence(op1);
        int p2 = getPrecedence(op2);
        return p1 >= p2;
    }
    private static int getPrecedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return 0;
    }
    private static void calculateAndPush(Stack<Float> numberStack, String operator) {
        float num2 = numberStack.pop();
        float num1 = numberStack.pop();

        if (operator.equals("+")) {
            numberStack.push(num1+num2);
        } else if (operator.equals("-")) {
            numberStack.push(num1-num2);
        } else if (operator.equals("*")) {
            numberStack.push(num1*num2);
        } else if (operator.equals("/")) {
            numberStack.push(num1/num2);
        }
    }
}
