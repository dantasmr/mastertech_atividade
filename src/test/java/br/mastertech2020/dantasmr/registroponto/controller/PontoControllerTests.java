package br.mastertech2020.dantasmr.registroponto.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
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
import br.mastertech2020.dantasmr.registroponto.service.PontoService;

@RunWith(MockitoJUnitRunner.class)
public class PontoControllerTests {
	
	@InjectMocks
	private PontoController pontoController;
	
	
	@Mock
	private PontoService pontoServiceMock;
	
	@Before
	public void initMocks() {
		
		
		
		ListagemPontoDTO listagemPontoDTO = new ListagemPontoDTO();
		listagemPontoDTO.setPontos(null);
		listagemPontoDTO.setTotalhoras(1);
		Optional<ListagemPontoDTO> listagem  = Optional.of(listagemPontoDTO);
		
		when(pontoServiceMock.getRegistrosPontoByUserId(anyInt())).thenReturn(listagem) ;
		


	}
	
	@Test
	public void TestListagem() {
		
		ResponseEntity<ListagemPontoDTO> resu = pontoController.getRegistrosPonto(1);
		assertNotNull(resu);
	}
	
	
	
}
