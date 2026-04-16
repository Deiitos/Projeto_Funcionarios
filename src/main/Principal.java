package main;

//classe Funcionario
import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
	
    public static void main(String[] args) {
        //lista para armazenar os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

     // 3.1 Inserir funcionários
     funcionarios.add(new Funcionario(
             "Maria", 
             LocalDate.of(2000, 10, 18), 
             new BigDecimal("2009.44"), 
             "Operador"
     ));

     funcionarios.add(new Funcionario(
             "João",
             LocalDate.of(1990, 5, 12),
             new BigDecimal("2284.38"),
             "Operador"
     ));

     funcionarios.add(new Funcionario(
             "Caio",
             LocalDate.of(1961, 5, 2),
             new BigDecimal("9836.14"),
             "Coordenador"
     ));

     funcionarios.add(new Funcionario(
             "Miguel",
             LocalDate.of(1988, 10, 14),
             new BigDecimal("19119.88"),
             "Diretor"
     ));

     funcionarios.add(new Funcionario(
             "Alice",
             LocalDate.of(1995, 1, 5),
             new BigDecimal("2234.68"),
             "Recepcionista"
     ));

     funcionarios.add(new Funcionario(
             "Heitor",
             LocalDate.of(1999, 11, 19),
             new BigDecimal("1582.72"),
             "Operador"
     ));

     funcionarios.add(new Funcionario(
             "Arthur",
             LocalDate.of(1993, 3, 31),
             new BigDecimal("4071.84"),
             "Contador"
     ));

     funcionarios.add(new Funcionario(
             "Laura",
             LocalDate.of(1994, 7, 8),
             new BigDecimal("3017.45"),
             "Gerente"
     ));

     funcionarios.add(new Funcionario(
             "Heloísa",
             LocalDate.of(2003, 5, 24),
             new BigDecimal("1606.85"),
             "Eletricista"
     ));

     funcionarios.add(new Funcionario(
             "Helena",
             LocalDate.of(1996, 9, 2),
             new BigDecimal("2799.93"),
             "Gerente"
     ));

        // 3.2 Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimir funcionários
        System.out.println("Lista de funcionários:");
        
        // Formatação de data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // milhar com ponto e decimal com vírgula
        DecimalFormat df = new DecimalFormat("#,##0.00");

        for (Funcionario f : funcionarios) {

            // Imprime os dados formatados
            System.out.println(
                    f.getNome() + " - " + 
                    f.getDataNascimento().format(formatter) + " - " + 
                    "R$ " + df.format(f.getSalario()) + " - " + 
                    f.getFuncao() 
            );
        }

        // 3.4 Aumento de 10%
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
        }
        
        // 3.5 Agrupar por função
        // 3.6 Imprimir agrupados
        

        // 3.8 Aniversários mês 10 e 12
        System.out.println("\nAniversariantes mês 10 e 12:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 ||
                             f.getDataNascimento().getMonthValue() == 12)
                .forEach(f -> System.out.println(f.getNome()));

        // 3.9 Funcionário mais velho
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .get();

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("\nFuncionario mais velho: " + maisVelho.getNome() + " - " + idade + " anos");

        // 3.10 Ordem alfabética
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nOrdem alfabética:");
        funcionarios.forEach(f -> System.out.println(f.getNome()));

        // 3.11 Total salários
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }
        System.out.println("\nTotal salários: R$ " + df.format(total));

        // 3.12 Salários mínimos
        //salário mínimo
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários mínimos:");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos");
        });
    }
}