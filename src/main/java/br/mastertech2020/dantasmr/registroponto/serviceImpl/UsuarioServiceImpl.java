package br.mastertech2020.dantasmr.registroponto.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.dto.UsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.repositories.UsuarioRepository;
import br.mastertech2020.dantasmr.registroponto.service.UsuarioService;
import br.mastertech2020.dantasmr.registroponto.util.UsuarioMapper;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Override
	public Usuario criaUsuario(NovoUsuarioDTO novoUsuarioDTO) {
		Usuario usuario = UsuarioMapper.toUsuario(novoUsuarioDTO);		
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Optional<Usuario> atualizaUsuario(int idUsuario, UsuarioDTO usuarioDTO) {
		
		Optional<Usuario> usuarioRepo = usuarioRepository.findById(idUsuario);
		
		if (usuarioRepo.isPresent()) {
			Usuario usuario = usuarioRepo.get();
			usuario.setNome(usuarioDTO.getNome());
			usuario.setCpf(usuarioDTO.getCpf());
			usuario.setEmail(usuarioDTO.getEmail());
			return Optional.of(usuarioRepository.save(usuario));
		}else {
			return usuarioRepo;
		}

	}
	
	@Override
	public Optional<Usuario> getUsuario(int idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}
	
	
	@Override
	public List<Usuario> getTodosUsuarios() {
		Iterable<Usuario> iterable = usuarioRepository.findAll();		
		List<Usuario> result = new ArrayList<Usuario>();
		iterable.forEach(result::add);
		return result;
	}



}
