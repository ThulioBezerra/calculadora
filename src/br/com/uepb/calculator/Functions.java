package br.com.uepb.calculator;

import java.util.LinkedList;
import java.util.regex.*;
public class Functions {
    public static float execute(String equacao) throws Exception{
        char[] caracteres = equacao.toCharArray();
        String token;
        LinkedList <String> operators = new LinkedList<>();
        LinkedList <Float> numbers = new LinkedList<>();
        float resultado;
        if(verifica_parenteses(caracteres));
        else throw new Exception("Parênteses mal posicionados.");
        Pattern pattern =     Pattern.compile("[-+]?\\d*\\.?\\d+|[+\\-*/]");
        Matcher matcher = pattern.matcher(equacao);
        while(matcher.find()){
            token = matcher.group();
            if (token.matches("[-+*/]")) {
                operators.add(token);
            } else if (token.matches("[()]")){
                numbers.add(Float.parseFloat(token));
            }
        }
        return resultado;
    }
    public static boolean  verifica_parenteses(char[] expressao){
        int verificador_parenteses=0;
        for (char x:expressao) {
            if (x=='(') verificador_parenteses++;
            else if (x==')') verificador_parenteses--;
            if(verificador_parenteses<0) return false;
        }
        if (verificador_parenteses>0) return false;
        return true;
    }
}
