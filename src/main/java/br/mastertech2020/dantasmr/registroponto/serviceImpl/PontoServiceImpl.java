package br.mastertech2020.dantasmr.registroponto.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mastertech2020.dantasmr.registroponto.dto.ListagemPontoDTO;
import br.mastertech2020.dantasmr.registroponto.dto.PontoDTO;
import br.mastertech2020.dantasmr.registroponto.models.Ponto;
import br.mastertech2020.dantasmr.registroponto.models.Usuario;
import br.mastertech2020.dantasmr.registroponto.repositories.PontoRepository;
import br.mastertech2020.dantasmr.registroponto.repositories.UsuarioRepository;
import br.mastertech2020.dantasmr.registroponto.service.PontoService;
import br.mastertech2020.dantasmr.registroponto.util.HorasTrabalhadasUtil;
import br.mastertech2020.dantasmr.registroponto.util.PontoMapper;

@Service
public class PontoServiceImpl implements PontoService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PontoRepository pontoRepository;

	@Override
	public Optional<Ponto> registraPonto(final int idUsuario, PontoDTO pontoDTO) {

		Optional<Usuario> usuarioRep = usuarioRepository.findById(idUsuario);
		if (usuarioRep.isPresent()) {						
			Ponto ponto = PontoMapper.toPonto(usuarioRep.get(), pontoDTO);
			return Optional.of(pontoRepository.save(ponto));		
		}else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<ListagemPontoDTO> getRegistrosPontoByUserId(int idUsuario) {
	
		Optional<Usuario> usuarioRep = usuarioRepository.findById(idUsuario);
		if (usuarioRep.isPresent()) {	
			return getListagemRepositorio(usuarioRep);
		}else {
			return Optional.empty();
		}		
	}

	private Optional<ListagemPontoDTO> getListagemRepositorio(Optional<Usuario> usuarioRep) {
		ListagemPontoDTO listagemPontoDTO = new ListagemPontoDTO();
		Iterable<Ponto> pontos = pontoRepository.findAllByUsuario_id(usuarioRep.get().getId());	
		listagemPontoDTO.setTotalhoras(HorasTrabalhadasUtil.getTotalHorasTrabalhadas(pontos));
		List<PontoDTO> pontosDTO = new ArrayList<PontoDTO>();
		pontos.forEach(ponto-> {
			pontosDTO.add(PontoMapper.toPontoDTO(ponto));			
		});
		listagemPontoDTO.setPontos(pontosDTO);		
		return Optional.of(listagemPontoDTO);
	}

}
