package br.mastertech2020.dantasmr.registroponto.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.mastertech2020.dantasmr.registroponto.dto.NovoUsuarioDTO;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;

public class UsuarioMapper {
	
	private static DateTimeFormatter formatter_date = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
	public static Usuario toUsuario(NovoUsuarioDTO novoUsuarioDTO) {			
		LocalDate localDate = LocalDate.parse(novoUsuarioDTO.getDatacadastro(), formatter_date);
		Usuario usuario = new Usuario();
		usuario.setNome(novoUsuarioDTO.getNome());
		usuario.setCpf(novoUsuarioDTO.getCpf());
		usuario.setEmail(novoUsuarioDTO.getEmail());
		usuario.setDatacadastro(localDate);
		return usuario;		
	}
	
	

}


