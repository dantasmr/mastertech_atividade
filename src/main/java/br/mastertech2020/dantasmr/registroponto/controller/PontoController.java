package br.mastertech2020.dantasmr.registroponto.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.mastertech2020.dantasmr.registroponto.dto.ListagemPontoDTO;
import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;
import br.mastertech2020.dantasmr.registroponto.service.PontoService;


@RestController
@RequestMapping("/api/v1")
public class PontoController {

	@Autowired
	private PontoService pontoService;

	@GetMapping("/usuarios/{id}/registro_ponto")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ListagemPontoDTO> getRegistrosPonto(@PathVariable(value = "id") int idUsuario) {
		
		Optional<ListagemPontoDTO> listagem = pontoService.getRegistrosPontoByUserId(idUsuario);
		if (listagem.isPresent()) {
			return ResponseEntity.ok(listagem.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}

	@PostMapping("/usuarios/{id}/registro_ponto")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Ponto> updateUser(@PathVariable(value = "id") int idUsuario,
			@Valid @RequestBody PontoDTO pontoDTO) {
		Optional<Ponto> ponto = pontoService.registraPonto(idUsuario, pontoDTO);
		
		if (ponto.isPresent()) {
			return ResponseEntity.ok(ponto.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
