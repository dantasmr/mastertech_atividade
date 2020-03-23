package br.mastertech2020.dantasmr.registroponto.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.mastertech2020.dantasmr.registroponto.models.Batida;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PontoDTO {
	
	@NotNull(message = "Obrigatorio informar tipo de batida: Entrada ou Saida")
	private Batida batida;
	
	@NotNull(message = "Obrigatorio informar data e hora")
	private String datahora;

	public Batida getBatida() {
		return batida;
	}

	public void setBatida(Batida batida) {
		this.batida = batida;
	}

	public String getDatahora() {
		return datahora;
	}

	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	
	
	

}
