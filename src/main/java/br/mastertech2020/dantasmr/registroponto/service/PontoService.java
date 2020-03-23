package br.mastertech2020.dantasmr.registroponto.service;

import java.util.Optional;

import br.mastertech2020.dantasmr.registroponto.dto.ListagemPontoDTO;
import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;

public interface PontoService {
		
	public Optional<Ponto> registraPonto(final int idUsuario, final PontoDTO pontoDTO);
	public Optional<ListagemPontoDTO> getRegistrosPontoByUserId(final int idUser);

}
