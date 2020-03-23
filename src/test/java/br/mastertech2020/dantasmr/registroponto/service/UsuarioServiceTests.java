package br.mastertech2020.dantasmr.registroponto.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.dto.UsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.repositories.UsuarioRepository;
import br.mastertech2020.dantasmr.registroponto.serviceImpl.UsuarioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTests {
	
	@InjectMocks
	private UsuarioServiceImpl usuarioService;

	@Mock
	private UsuarioRepository usuarioRepositoryMock;
		
	@Before
	public void iniciaMocks() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(1);
		usuario1.setCpf("12345678900");
		usuario1.setNome("Mock nome1");
		usuario1.setEmail("teste@email.com.br");
		usuario1.setDatacadastro(LocalDate.now());
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2);
		usuario2.setCpf("12345678900");
		usuario2.setNome("Mock nome2");
		usuario2.setEmail("teste@email.com.br");
		usuario2.setDatacadastro(LocalDate.now());
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Optional<Usuario> usuarioRep = Optional.of(usuario1);
		when(usuarioRepositoryMock.findById(anyInt())).thenReturn(usuarioRep);
		when(usuarioRepositoryMock.save(any(Usuario.class))).thenReturn(usuario1);
		when(usuarioRepositoryMock.findAll()).thenReturn(usuarios);
		
		
	}
	
	
	
	@Test
	public void testCriaUsuario() {
		
		NovoUsuarioDTO novoUsuarioDTO = new NovoUsuarioDTO();
		novoUsuarioDTO.setCpf("122232322");
		novoUsuarioDTO.setDatacadastro("01/03/2020");
		novoUsuarioDTO.setEmail("email@teste.com.br");
		novoUsuarioDTO.setNome("Nome usuario");
		
		Usuario usuario = usuarioService.criaUsuario(novoUsuarioDTO);
		assertNotNull(usuario);
				
	}
	
	@Test
	public void testAtualizaUsuario() {
		
		UsuarioDTO novoUsuarioDTO = new UsuarioDTO();
		novoUsuarioDTO.setCpf("122232322");
		novoUsuarioDTO.setEmail("email@teste.com.br");
		novoUsuarioDTO.setNome("Nome usuario");
		Optional<Usuario> usuario = usuarioService.atualizaUsuario(1, novoUsuarioDTO);
		assertNotNull(usuario);
		
	}
	
	@Test
	public void testGetTodosUsuarios() {
		
		UsuarioDTO novoUsuarioDTO = new UsuarioDTO();
		novoUsuarioDTO.setCpf("122232322");
		novoUsuarioDTO.setEmail("email@teste.com.br");
		novoUsuarioDTO.setNome("Nome usuario");
		List<Usuario> usuarios = usuarioService.getTodosUsuarios();
		assertNotNull(usuarios);
		
	}
	

	

	
}