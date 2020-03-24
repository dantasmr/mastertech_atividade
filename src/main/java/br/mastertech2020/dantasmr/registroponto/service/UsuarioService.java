package br.mastertech2020.dantasmr.registroponto.service;

import java.util.List;
import java.util.Optional;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.dto.UsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;

public interface UsuarioService {
	
	public Usuario criaUsuario(NovoUsuarioDTO novoUsuarioDTO);
	public Optional<Usuario> atualizaUsuario(final int idUsuario, UsuarioDTO usuarioDTO);
	public Optional<Usuario> getUsuario(final int idUsuario);
	public List<Usuario> getTodosUsuarios();
		
}
