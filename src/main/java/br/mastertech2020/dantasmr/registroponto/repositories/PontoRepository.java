package br.mastertech2020.dantasmr.registroponto.repositories;

import org.springframework.data.repository.CrudRepository;

import br.mastertech2020.dantasmr.registroponto.models.Ponto;

public interface PontoRepository extends CrudRepository<Ponto, Integer>{

	Iterable<Ponto> findAllByUsuario_id(int usuarioId);
	  
}

