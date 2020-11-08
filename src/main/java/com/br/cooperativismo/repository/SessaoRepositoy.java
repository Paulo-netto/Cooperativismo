package com.br.cooperativismo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;

@Repository
public interface SessaoRepositoy extends JpaRepository<Sessao, Long> {

	Optional<Sessao> findByTipoVotacaoPauta(TipoVotacaoPauta tipoVotacaoPauta);

}
