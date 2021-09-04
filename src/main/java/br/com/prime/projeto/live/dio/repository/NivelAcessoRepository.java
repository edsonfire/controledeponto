package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;
import br.com.prime.projeto.live.dio.modelo.NivelAcesso;

public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long> {

}
