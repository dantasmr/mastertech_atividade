package br.mastertech2020.dantasmr.registroponto.util;

import java.time.Duration;
import java.time.LocalDateTime;

import br.mastertech2020.dantasmr.registroponto.models.Batida;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;

public final class HorasTrabalhadasUtil {
	
		
	private HorasTrabalhadasUtil() {
		
	}
	
	
	public static long getTotalHorasTrabalhadas(Iterable<Ponto> pontos) {
		
		long totalMinutos=0;
		LocalDateTime dataHoraEntrada=null;
		LocalDateTime dataHoraSaida=null;
		
		for(Ponto ponto : pontos){
			
			if (Batida.Entrada.equals(ponto.getBatida())) {
				dataHoraEntrada = ponto.getDatahora();
			}else {
				dataHoraSaida = ponto.getDatahora();
			}
			
			if (dataHoraEntrada != null && dataHoraSaida != null) {
				totalMinutos += calculaTotalMinutos(dataHoraEntrada, dataHoraSaida);
				dataHoraEntrada = null;
				dataHoraSaida = null;
			}
			
		}
		
		return totalMinutos / 60;

	}
	
	
	
	private static long calculaTotalMinutos(LocalDateTime dateTimeStart, LocalDateTime dateTimeStop) {
		
		Duration duration = Duration.between(dateTimeStart, dateTimeStop);
		return duration.toMinutes();

	}
	

}
