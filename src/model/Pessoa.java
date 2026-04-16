package model;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private	LocalDate dataNascimento;
	
	//
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	
	//Metodos de retorno	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
}
