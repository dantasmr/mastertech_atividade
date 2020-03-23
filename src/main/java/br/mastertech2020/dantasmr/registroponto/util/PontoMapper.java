package br.mastertech2020.dantasmr.registroponto.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;

public class PontoMapper {

	public static DateTimeFormatter formatter_datetime = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
	
	public static Ponto toPonto(Usuario usuario, PontoDTO pontoDTO) {			
		LocalDateTime localDateTime = LocalDateTime.parse(pontoDTO.getDatahora(), formatter_datetime);
		Ponto ponto = new Ponto();
		ponto.setUsuario(usuario);
		ponto.setBatida(pontoDTO.getBatida());
		ponto.setDatahora(localDateTime);
		return ponto;
	}
	
	
	public static PontoDTO toPontoDTO(Ponto ponto) {		
		
		PontoDTO pontoDTO = new PontoDTO();
		pontoDTO.setBatida(ponto.getBatida());
		pontoDTO.setDatahora(ponto.getDatahora().format(formatter_datetime));
		return pontoDTO;
	
	}
	
	
	
	
}
