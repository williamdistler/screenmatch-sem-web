package br.com.alura.screenmatch.desafios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface Multiplicacao {
    int multiplicacao(int a, int b);
}

@FunctionalInterface
interface NumeroPrimo {
    boolean numeroPrimo(int n);
}

@FunctionalInterface
interface StringMaiuscula {
    String upperCase(String s);
}

@FunctionalInterface
interface Palindromo {
    boolean verificarPalindromo(String str);
}

interface Divisor {
    int dividir(int a, int b) throws ArithmeticException;
}

public class Desafios {
    public static void main(String[] args) {
        Multiplicacao multiplicacao = (a, b) -> a * b;
        System.out.println(multiplicacao.multiplicacao(5, 3));

        NumeroPrimo numeroPrimo = (n) -> {
            if (n <= 1)
                return false;
            int raizN;
            for (raizN = 2; raizN <= n; raizN++) {
                if ((raizN * raizN) > n)
                    break;
            }
            for (int i = 2; i < raizN; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
        System.out.println(numeroPrimo.numeroPrimo(2));

        StringMaiuscula upperCase = (s) -> s.toUpperCase();
        System.out.println(upperCase.upperCase("William"));

        Palindromo palindromo = (s) -> s.equals(new StringBuilder(s).reverse().toString());
        System.out.println(palindromo.verificarPalindromo("socorrammesubinoonibusemmarrocos"));

        List<Integer> inteiros = new ArrayList<>();
        inteiros.add(1);
        inteiros.add(2);
        inteiros.add(3);
        inteiros.replaceAll(i -> i * 3);
        System.out.println(inteiros);

        List<String> palavras = new ArrayList<>();
        palavras.add("Abobora");
        palavras.add("Sebra");
        palavras.add("Bola");
        palavras.sort(Comparator.naturalOrder());
        System.out.println(palavras);

        Divisor divisor = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por zero");
            return a / b;
        };

        try {
            System.out.println(divisor.dividir(10, 2)); // Esperado: 5
            System.out.println(divisor.dividir(10, 0)); // Esperado: Exceção
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
