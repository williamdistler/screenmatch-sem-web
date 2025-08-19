package br.com.alura.screenmatch.desafios;

import java.util.*;

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
//        Multiplicacao multiplicacao = (a, b) -> a * b;
//        System.out.println(multiplicacao.multiplicacao(5, 3));
//
//        NumeroPrimo numeroPrimo = (n) -> {
//            if (n <= 1)
//                return false;
//            int raizN;
//            for (raizN = 2; raizN <= n; raizN++) {
//                if ((raizN * raizN) > n)
//                    break;
//            }
//            for (int i = 2; i < raizN; i++) {
//                if (n % i == 0)
//                    return false;
//            }
//            return true;
//        };
//        System.out.println(numeroPrimo.numeroPrimo(2));
//
//        StringMaiuscula upperCase = (s) -> s.toUpperCase();
//        System.out.println(upperCase.upperCase("William"));
//
//        Palindromo palindromo = (s) -> s.equals(new StringBuilder(s).reverse().toString());
//        System.out.println(palindromo.verificarPalindromo("socorrammesubinoonibusemmarrocos"));
//
//        List<Integer> inteiros = new ArrayList<>();
//        inteiros.add(1);
//        inteiros.add(2);
//        inteiros.add(3);
//        inteiros.replaceAll(i -> i * 3);
//        System.out.println(inteiros);
//
//        List<String> palavras = new ArrayList<>();
//        palavras.add("Abobora");
//        palavras.add("Sebra");
//        palavras.add("Bola");
//        palavras.sort(Comparator.naturalOrder());
//        System.out.println(palavras);
//
//        Divisor divisor = (a, b) -> {
//            if (b == 0) throw new ArithmeticException("Divisão por zero");
//            return a / b;
//        };
//
//        try {
//            System.out.println(divisor.dividir(10, 2)); // Esperado: 5
//            System.out.println(divisor.dividir(10, 0)); // Esperado: Exceção
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> numerosMultiplicados = numeros2.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .toList();
        System.out.println(numerosMultiplicados);

        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        palavras2.stream()
                .distinct()
                .forEach(System.out::println);

        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        List<Integer> numerosPrimos = listaDeNumeros.stream()
                .flatMap(Collection::stream)
                .filter(n -> {
                    if (n <= 1) return false;
                    for (int i = 2; i * i <= n; i++) {
                        if (n % i == 0) return false;
                    }
                    return true;
                }).toList();
        System.out.println(numerosPrimos);

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .map(Pessoa::getNome)
                .sorted()
                .forEach(System.out::println);
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> produtosEletronicos1000 = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .filter(p -> p.getPreco() < 1000.0)
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();
        System.out.println(produtosEletronicos1000);

        produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco))
                .limit(3)
                .forEach(System.out::println);
    }


}
