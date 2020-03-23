package br.mastertech2020.dantasmr.registroponto.dto;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NovoUsuarioDTO extends UsuarioDTO{
		
	@NotNull(message = "Obrigatorio informar a data do cadastro no formato dd-mm-yyyy")
	protected String datacadastro;
		
	public String getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(String datacadastro) {
		this.datacadastro = datacadastro;
	}
		

}
