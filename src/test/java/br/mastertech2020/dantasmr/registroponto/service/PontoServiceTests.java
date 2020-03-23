package br.mastertech2020.dantasmr.registroponto.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.mastertech2020.dantasmr.registroponto.dto.ListagemPontoDTO;
import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Batida;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.repositories.PontoRepository;
import br.mastertech2020.dantasmr.registroponto.repositories.UsuarioRepository;
import br.mastertech2020.dantasmr.registroponto.serviceImpl.PontoServiceImpl;
import br.mastertech2020.dantasmr.registroponto.util.PontoMapper;

@RunWith(MockitoJUnitRunner.class)
public class PontoServiceTests {
	
	@InjectMocks
	private PontoServiceImpl pontoService;
		
	@Mock
	private UsuarioRepository usuarioRepositoryMock;
	
	@Mock
	private PontoRepository pontoRepositoryMock;
		
	@Before
	public void iniciaMocks() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setCpf("12345678900");
		usuario.setNome("Mock nome");
		usuario.setEmail("teste@email.com.br");
		usuario.setDatacadastro(LocalDate.now());
		
		Ponto ponto = new Ponto();
		ponto.setId(1);
		ponto.setBatida(Batida.Entrada);
		ponto.setUsuario(usuario);
		
		Optional<Usuario> usuarioRep = Optional.of(usuario);
		when(usuarioRepositoryMock.findById(anyInt())).thenReturn(usuarioRep);
		when(pontoRepositoryMock.save(any(Ponto.class))).thenReturn(ponto);
		
		
		Ponto pontoEntrada = new Ponto();
		pontoEntrada.setId(1);
		pontoEntrada.setBatida(Batida.Entrada);
		pontoEntrada.setUsuario(usuario);
		pontoEntrada.setDatahora(LocalDateTime.parse("22/03/2020 01:00:00", PontoMapper.formatter_datetime));
		
		Ponto pontoSaida = new Ponto();
		pontoSaida.setId(2);
		pontoSaida.setBatida(Batida.Saida);
		pontoSaida.setUsuario(usuario);
		pontoSaida.setDatahora(LocalDateTime.parse("22/03/2020 02:00:00", PontoMapper.formatter_datetime));
		
		List<Ponto> pontos = new ArrayList<Ponto>();
		pontos.add(pontoEntrada);
		pontos.add(pontoSaida);
		
		when(pontoRepositoryMock.findAllByUsuario_id(anyInt())).thenReturn(pontos);
		

		
	}
	
	
	
	@Test
	public void testRegistraPonto() {
		
		PontoDTO pontoDTO = new PontoDTO();
		pontoDTO.setBatida(Batida.Entrada);
		pontoDTO.setDatahora("22/03/2020 01:00:00");
		
		Optional<Ponto> ponto = pontoService.registraPonto(1, pontoDTO);
		assertNotNull(ponto);
				
	}
	
	@Test
	public void testGetRegistrosPontoByUserId() {
		
		Optional<ListagemPontoDTO> listagem = pontoService.getRegistrosPontoByUserId(1);
	
		assertNotNull(listagem);
		
		
		if (listagem.isPresent()) {
			long totalhoras = listagem.get().getTotalhoras();
			assertEquals(1, totalhoras);
		}
		
	}
	


	
}