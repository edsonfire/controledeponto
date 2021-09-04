package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.Movimentacao;
import br.com.prime.projeto.live.dio.modelo.Movimentacao.MovimentacaoId;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {

}
