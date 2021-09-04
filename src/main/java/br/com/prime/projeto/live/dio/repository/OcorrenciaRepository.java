package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}
