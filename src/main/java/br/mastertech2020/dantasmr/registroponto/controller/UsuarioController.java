package br.mastertech2020.dantasmr.registroponto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.dto.UsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.service.UsuarioService;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok(usuarioService.getTodosUsuarios());
	}

	@GetMapping("/usuarios/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Usuario> getUsuario(@PathVariable(value = "id") int idUsuario) {
		
		Optional<Usuario> usuario = usuarioService.getUsuario(idUsuario);
		
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	@PostMapping("/usuarios")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario novo(@Valid @RequestBody NovoUsuarioDTO novoUsuarioDTO) {
		return usuarioService.criaUsuario(novoUsuarioDTO);
	}

	@PutMapping("/usuarios/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Usuario> updateUser(@PathVariable(value = "id") int idUser,
			@Valid @RequestBody UsuarioDTO usuarioDTO) {
		Optional<Usuario> usuarioUpdate = usuarioService.atualizaUsuario(idUser, usuarioDTO);
		
		if (usuarioUpdate.isPresent()) {
			return ResponseEntity.ok(usuarioUpdate.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
