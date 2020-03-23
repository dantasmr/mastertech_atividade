package br.mastertech2020.dantasmr.registroponto.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import br.mastertech2020.dantasmr.registroponto.dto.ListagemPontoDTO;
import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;
import br.mastertech2020.dantasmr.registroponto.service.PontoService;

@RunWith(MockitoJUnitRunner.class)
public class PontoControllerTests {
	
	@InjectMocks
	private PontoController pontoController;
	
	
	@Mock
	private PontoService pontoServiceMock;
	
	
	@Test
	public void testGetRegistrosPonto() {
		
		ListagemPontoDTO listagemPontoDTO = new ListagemPontoDTO();
		listagemPontoDTO.setPontos(null);
		listagemPontoDTO.setTotalhoras(1);
		Optional<ListagemPontoDTO> listagem  = Optional.of(listagemPontoDTO);
		
		when(pontoServiceMock.getRegistrosPontoByUserId(anyInt())).thenReturn(listagem) ;
		
		ResponseEntity<ListagemPontoDTO> resu = pontoController.getRegistrosPonto(1);
		assertNotNull(resu);
	}
	
	@Test
	public void testUpdateUser() {
		
		Ponto ponto = new Ponto();
		ponto.setId(1);

		Optional<Ponto> pontoOptional = Optional.of(ponto);
		
		when(pontoServiceMock.registraPonto(anyInt(), any(PontoDTO.class))).thenReturn(pontoOptional) ;
		
		PontoDTO pontoDTO = new PontoDTO();
		ResponseEntity<Ponto> resu = pontoController.updateUser(1, pontoDTO);
		assertNotNull(resu);
	}
	
	

	
}
