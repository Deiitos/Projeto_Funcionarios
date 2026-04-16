package model;

//BigDecimal para trabalhar com valores monetários e LocalDate para datas
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

 private BigDecimal salario;
 private String funcao;

 public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
     // Chama o construtor da classe Pessoa
     super(nome, dataNascimento);

     // Define o salário  função
     this.salario = salario;
     this.funcao = funcao;
 }

 // Getter para retornar o salário
 public BigDecimal getSalario() {
     return salario;
 }

 // Setter para alterar o salário (usado no aumento de 10%)
 public void setSalario(BigDecimal salario) {
     this.salario = salario;
 }

 // Getter para retornar a função
 public String getFuncao() {
     return funcao;
 }
}