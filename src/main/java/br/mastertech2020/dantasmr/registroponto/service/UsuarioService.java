package br.mastertech2020.dantasmr.registroponto.service;

import java.util.List;
import java.util.Optional;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.dto.UsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;

public interface UsuarioService {
	
	public Usuario criaUsuario(NovoUsuarioDTO novoUsuarioDTO);
	public Optional<Usuario> atualizaUsuario(int idUser, UsuarioDTO usuarioDTO);
	public List<Usuario> getTodosUsuarios();
		
}
