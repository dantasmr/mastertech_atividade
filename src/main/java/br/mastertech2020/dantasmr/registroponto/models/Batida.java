package br.mastertech2020.dantasmr.registroponto.models;

public enum Batida {
	
	
	  Entrada("Entrada"),
	  Saida("Saida");
	
	  private String nome;
	  
	  private Batida(String nome) {
	    this.nome = nome;
	  }
	  
	  public String getNome() {
	    return nome;
	  }
	}