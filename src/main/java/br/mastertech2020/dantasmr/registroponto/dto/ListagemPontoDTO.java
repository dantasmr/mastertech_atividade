package br.mastertech2020.dantasmr.registroponto.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListagemPontoDTO {
		
	private List<PontoDTO> pontos;
	private long totalhoras;
	
	public List<PontoDTO> getPontos() {
		return pontos;
	}
	public void setPontos(List<PontoDTO> pontos) {
		this.pontos = pontos;
	}
	
	public long getTotalhoras() {
		return totalhoras;
	}
	public void setTotalhoras(long totalhoras) {
		this.totalhoras = totalhoras;
	}
	


	
}
