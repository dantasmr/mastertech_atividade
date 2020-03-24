package br.mastertech2020.dantasmr.registroponto.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTests {
	
	@InjectMocks
	private UsuarioController usuarioController;
		
	@Mock
	private UsuarioService usuarioServiceMock;
	
	@Test
	public void testGetUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		Optional<Usuario> usuarioOptional = Optional.of(usuario);
		when(usuarioServiceMock.getUsuario(anyInt())).thenReturn(usuarioOptional) ;		
		ResponseEntity<Usuario> resu = usuarioController.getUsuario(1);
		assertNotNull(resu);
	}
		
	@Test
	public void testGetUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();		
		when(usuarioServiceMock.getTodosUsuarios()).thenReturn(usuarios) ;		
		ResponseEntity<List<Usuario>> resu = usuarioController.getUsuarios();
		assertNotNull(resu);
	}
	
	@Test
	public void testNovoUsuario() {
				
		Usuario usuario = new Usuario();
		usuario.setId(1);
		when(usuarioServiceMock.criaUsuario(any(NovoUsuarioDTO.class))).thenReturn(usuario);
		
		
		NovoUsuarioDTO novoUsuarioDTO = new NovoUsuarioDTO();
		novoUsuarioDTO.setCpf("12333333");
		Usuario resu = usuarioController.novo(novoUsuarioDTO);
		assertNotNull(resu);

	}
	
	@Test
	public void testupdateUser() {
				
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Optional<Usuario> usuarioOptional = Optional.of(usuario);
		when(usuarioServiceMock.atualizaUsuario(anyInt(),any(NovoUsuarioDTO.class))).thenReturn(usuarioOptional);
		
		
		NovoUsuarioDTO novoUsuarioDTO = new NovoUsuarioDTO();
		novoUsuarioDTO.setCpf("12333333");
		ResponseEntity<Usuario> resu = usuarioController.updateUser(1, novoUsuarioDTO);
		assertNotNull(resu);

	}
	
	
}
